package com.example.transactionprocessor.runtime.error.rest;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import lombok.ToString;
import com.example.transactionprocessor.runtime.error.constant.Errors;
@ToString
@JsonPropertyOrder({"code", "message", "errorDetails", "traceId", "timestamp"})
public class ApiError implements Serializable {

    @Schema(example = "API_NOT_FOUND", implementation = Errors.class)
    private final String code;

    @Schema(example = "User not found")
    private final String message;

    @Schema(example = "2021-07-06T13:00:48.414287Z")
    private final Instant timestamp;

    public ApiError(@JsonProperty("code") String code, @JsonProperty("message") String message) {
        super();
        this.code = code;
        this.message = message;
        this.timestamp = Instant.now();

    }

    @JsonProperty(value = "code")
    public String getCode() {
        return code;
    }

    @JsonProperty(value = "message")
    public String getMessage() {
        return message;
    }

    @JsonProperty(value = "timestamp")
    public Instant getTimestamp() {
        return timestamp;
    }

}