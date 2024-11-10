package com.example.transactionprocessor.client.model;

import static java.util.Objects.isNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Data;

/**
 * Supporting POJO for request/response logging.
 */
@Data
public class RequestResponseDetails {

    @JsonIgnore
    private static final String LINE_BREAK = "\n";

    @JsonProperty("request_type")
    private String requestType;
    @JsonProperty("request_method")
    private String requestMethod;
    @JsonProperty("request_url")
    private String requestUrl;
    @JsonProperty("request_headers")
    private Map<String, String> requestHeaders;
    @JsonProperty("request_payload")
    private String requestPayload;
    @JsonProperty("response_headers")
    private Map<String, String> responseHeaders;
    @JsonProperty("response_payload")
    private String responsePayload;
    @JsonProperty("response_code")
    private int responseCode;
    @JsonProperty("membership_id")
    private String membershipId;
    @JsonProperty("request_duration")
    private double requestDuration;


    @Override
    public String toString() {
        var builder = new StringBuilder();
        builder.append(LINE_BREAK);
        builder.append(
            String.format("###  HTTP %s %s Request  ###" + LINE_BREAK,
                this.requestMethod, this.requestUrl
            )
        );

        builder.append("###  Request Headers  ###" + LINE_BREAK);
        builder.append(formatHeaders(this.requestHeaders));

        builder.append(LINE_BREAK);
        builder.append(
            String.format(
                "###  HTTP %s Webclient Response (%.2f)  ###" + LINE_BREAK,
                responseCode, requestDuration
            )
        );

        builder.append("###  Response Headers  ###" + LINE_BREAK);
        builder.append(formatHeaders(this.responseHeaders) + LINE_BREAK);
        builder.append("###  Response body  ###" + LINE_BREAK);

        if(isNull(responsePayload) || "".equals(responsePayload)) {
            builder.append("No body available" + LINE_BREAK);
        } else {
            builder.append(
                this.responsePayload + LINE_BREAK
            );
        }

        return builder.toString();
    }

    private String formatHeaders(Map<String, String> headers) {
        var builder = new StringBuilder();
        headers.forEach((name, value) -> {
            builder.append(
                String.format("%s: %s" + LINE_BREAK, name, value)
            );
        });
        return builder.toString();
    }
}
