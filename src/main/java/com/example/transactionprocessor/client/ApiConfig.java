package com.example.transactionprocessor.client;


import lombok.extern.slf4j.Slf4j;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.CaptureApi;
import org.openapitools.client.api.PaymentsApi;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Configuration
public class ApiConfig {
    @Value("${cyber-source.base-url}")
    private String baseUrl;

    private final WebClient cyberSourcewebClient;

    public ApiConfig(
            @Qualifier("cyberSourceWebClient") WebClient cyberSourcewebClient,
            @Value("${cyber-source.base-url}") String baseUrl
    ) {
        this.baseUrl = baseUrl;
        this.cyberSourcewebClient = cyberSourcewebClient;
    }


    @Bean
    public PaymentsApi paymentsApi() {
        return new PaymentsApi(
                new ApiClient(cyberSourcewebClient).setBasePath(baseUrl)
        );
    }

    @Bean
    public CaptureApi captureApi() {
        return new CaptureApi(
                new ApiClient(cyberSourcewebClient).setBasePath(baseUrl)
        );
    }


}
