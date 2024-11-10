package com.example.transactionprocessor.runtime.error.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

@Getter
public class CyberSourceError extends Exception {
    private final String errorCode;
    private final String errorDetails;

    public CyberSourceError(String errorCode, String errorDetails) {
        super(errorDetails);
        this.errorCode = errorCode;
        this.errorDetails = errorDetails;
    }


}
