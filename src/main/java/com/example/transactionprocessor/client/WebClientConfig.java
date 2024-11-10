package com.example.transactionprocessor.client;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static net.logstash.logback.argument.StructuredArguments.fields;

import com.example.transactionprocessor.client.model.RequestResponseDetails;
import com.example.transactionprocessor.config.JacksonConfig;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelOption;
import io.netty.channel.epoll.EpollChannelOption;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.client.model.CreatePaymentRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@Slf4j
@Configuration
public class WebClientConfig {

    @Value("${cyber-source.host}")
    private String host;

    @Value("${cyber-source.org-id}")
    private String orgId;

    @Value("${cyber-source.api-key}")
    private String apiKey;

    @Value("${cyber-source.api-secret}")
    private String apiSecret;

    public static final int WEBCLIENT_BUFFFER_SIZE_MB = 10;
    public static final int BYTE_MULTIPLIER = 1024;

    private final ObjectMapper serverMapper;

    private final ObjectMapper cyberSourceMapper;

    public WebClientConfig(
            @Qualifier(JacksonConfig.SERVER_OBJECT_MAPPER) ObjectMapper serverMapper,
            @Qualifier(JacksonConfig.CYBERSOURCE_OBJECT_MAPPER) ObjectMapper cyberSourceMapper
    ) {
        // Initialize the object mapper
        this.serverMapper = serverMapper;
        this.cyberSourceMapper = cyberSourceMapper;
    }


    @Bean
    public HttpClient httpClient() {
        ConnectionProvider provider =
                ConnectionProvider.builder("custom")
                        .pendingAcquireMaxCount(-1)
                        .maxConnections(500)
                        .maxIdleTime(Duration.ofSeconds(20))
                        .maxLifeTime(Duration.ofSeconds(60))
                        .pendingAcquireTimeout(Duration.ofSeconds(60))
                        .evictInBackground(Duration.ofSeconds(120))
                        .build();

        return HttpClient
                .create(provider)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(EpollChannelOption.TCP_KEEPIDLE, 300)
                .option(EpollChannelOption.TCP_KEEPINTVL, 60)
                .option(EpollChannelOption.TCP_KEEPCNT, 8);
    }

    @Bean
    @Qualifier("cyberSourceWebClient")
    public WebClient cyberSourceWebClient(WebClient.Builder webClientBuilder, HttpClient httpClient) {

        ExchangeStrategies strategies = ExchangeStrategies
                .builder()
                .codecs(clientDefaultCodecsConfigurer -> {
                    clientDefaultCodecsConfigurer.defaultCodecs()
                            .jackson2JsonDecoder(
                                    new Jackson2JsonDecoder(cyberSourceMapper, MediaType.APPLICATION_JSON)
                            );
                    clientDefaultCodecsConfigurer.defaultCodecs()
                            .jackson2JsonEncoder(
                                    new Jackson2JsonEncoder(cyberSourceMapper, MediaType.APPLICATION_JSON)
                            );

                })
                .build();

        //var authPassFilter = new CustomHeaderServletBearerExchangeFilterFunction(HttpHeaders.AUTHORIZATION);

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .codecs(configurer -> configurer.defaultCodecs()
                        .maxInMemorySize(WEBCLIENT_BUFFFER_SIZE_MB * BYTE_MULTIPLIER
                                * BYTE_MULTIPLIER))
                .exchangeStrategies(strategies)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .filter(buildHeaders())
                .filter(logRequestAndResponse())
                .build();
    }

    private String hashPayload(String payload) {
        //Follow these steps to generate the hash:
        // 1.Generate the SHA-256 hash of the JSON payload (body of the message).
        // 2.Encode the hashed string to Base64.
        // 3.Prepend SHA-256= to the front of the hash.
        // 4.Add the message body hash to the digest header field
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(payload.getBytes(StandardCharsets.UTF_8));
            return "SHA-256=" + java.util.Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            log.error("Could not generate hash", e);
            return "";
        }
    }

    /**
     * Generate the signature for the request
     *
     * @param signatureParams
     * @return
     */
    public static String generateSignatureFromParams(String keyString,
                                                     String signatureParams)
            throws InvalidKeyException, NoSuchAlgorithmException {
        byte[] decodedKey = Base64.getDecoder().decode(keyString);
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "HmacSHA256");
        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
        hmacSha256.init(originalKey);
        hmacSha256.update(signatureParams.getBytes());
        byte[] HmachSha256DigestBytes = hmacSha256.doFinal();
        return Base64.getEncoder().encodeToString(HmachSha256DigestBytes);
    }



    /**
     * Generate the hash for the request payload
     *
     * @return
     */
    private ExchangeFilterFunction buildHeaders() {
        return (ClientRequest clientRequest, ExchangeFunction next) -> {
            var requestBody = Optional.of(clientRequest.body());
            if (requestBody.isPresent()) {
               // String jsonPayload = ((CreatePaymentRequest) requestBody.get()).toString().;

                //log.debug("Request Payload {}", jsonPayload);
                var digest = hashPayload(requestBody.get().toString());
                //var digest = "SHA-256=1wk5Hls1qcbZtjYDldGyl3B2i92v4rOqXyx6twRboEs=";
                // Get the current date in this example format
                // Sun, 10 Nov 2024 03:05:43 GMT
                var currentDate = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.RFC_1123_DATE_TIME);
                //var currentDate = "Sun, 10 Nov 2024 04:42:24 GMT";
                var apiPath = clientRequest.url().getPath();

                var signatureParams = "host: apitest.cybersource.com\n" +
                        "digest: " + digest + "\n" +
                        "v-c-merchant-id: " + orgId + "\n" +
                        "v-c-date: " + currentDate + "\n" +
                        "request-target: " + apiPath;

                String signatureHash = null;
                try {
                    signatureHash = generateSignatureFromParams(apiSecret, signatureParams);
                } catch (InvalidKeyException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
                //var signatureHash = "iJta9F6/okFttYHwSf4Axt8HswMYzC/oDSjCnUhDc3Y=";
                // Generate singature string following this format:
                // Signature:"keyid:"[shared secret key]",algorithm="[encryption algoritm]",headers="field1" "field2" "field3" "etc.", signature="[signature hash]"
                var signature = "keyid=\"" +
                        "b9e5fab9-2d75-4ddb-92f1-ac8639347648" +
                        "\", algorithm=\"HmacSHA256\", headers=\"host digest v-c-merchant-id v-c-date request-target\" ,signature=\"" +
                        signatureHash + "\"";
                //var signature = "keyid=\"b9e5fab9-2d75-4ddb-92f1-ac8639347648\", algorithm=\"HmacSHA256\", headers=\"host v-c-date request-target digest v-c-merchant-id\", signature=\"iJta9F6/okFttYHwSf4Axt8HswMYzC/oDSjCnUhDc3Y=\"";
                clientRequest = ClientRequest.from(clientRequest)
                        .header("host", host)
                        .header("digest", digest)
                        //.header("v-c-merchant-id", orgId)
                        .header("v-c-merchant-id", "testrest")
                        .header("v-c-date", currentDate)
                        .header("request-target", apiPath)
                        .header("signature", signature)
                        .build();

            }
            return next.exchange(clientRequest);
        };
    }

    /**
     * Log the request and response
     *
     * @return
     */
    private ExchangeFilterFunction logRequestAndResponse() {
        return (ClientRequest clientRequest, ExchangeFunction next) -> {
            if (log.isDebugEnabled()) {
                var details = new RequestResponseDetails();

                var startCallTime = System.currentTimeMillis();

                details.setRequestMethod(clientRequest.method().name());
                details.setRequestUrl(clientRequest.url().toString());

                log.debug("Request Header {}",  clientRequest.headers());
                log.debug("Request Payload {}",  clientRequest.body());


                return next.exchange(clientRequest).flatMap(
                        clientResponse -> {
                            var requestDuration = (System.currentTimeMillis() - startCallTime) / 1000.0;
                            details.setRequestDuration(requestDuration);
                            return logResponse(clientResponse, details);

                        }
                );
            } else {
                return next.exchange(clientRequest);
            }
        };
    }

    private Mono<ClientResponse> logResponse(ClientResponse response, RequestResponseDetails details) {
        if (response.statusCode() != null) {
            return response
                    .bodyToMono(String.class)
                    .single()
                    .flatMap(body -> {
                        try {
                            details.setResponseCode(response.statusCode().value());
                            details.setResponseHeaders(
                                    filterSensitiveHeaders(
                                            response.headers().asHttpHeaders(), List.of(HttpHeaders.AUTHORIZATION)
                                    )
                            );
                            if (isNull(body) || "".equals(body)) {
                                details.setResponsePayload("No body available");
                            } else {
                                var responseBody = serverMapper.writerWithDefaultPrettyPrinter().writeValueAsString(
                                        serverMapper.readValue(body, Object.class)
                                );
                                details.setResponsePayload(responseBody);
                                details.setRequestType("client");
                            }
                            log.debug("", fields(details));
                        } catch (JsonProcessingException ex) {
                            log.debug("Could not pretty print body", ex);
                            log.debug(body);
                        }
                        return Mono.just(response.mutate().body(body).build());
                    }).onErrorResume(
                            error -> {
                                log.debug("No webclient response body was present");
                                return Mono.just(response.mutate().build());
                            }
                    );
        } else {
            return Mono.just(response);
        }
    }

    private Map<String, String> filterSensitiveHeaders(HttpHeaders headers, List<String> headersToFilter) {
        Map<String, String> headerMap = new HashMap(headers.toSingleValueMap());

        if (nonNull(headersToFilter)) {
            headersToFilter.forEach(
                    header -> headerMap.computeIfPresent(header, (key, value) -> "XXX")
            );
        }

        return headerMap;
    }
}
