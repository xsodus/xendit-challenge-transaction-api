package com.example.transactionprocessor.runtime.error;

import com.example.transactionprocessor.runtime.error.exception.CyberSourceError;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

public class CyberSourceApiErrorHandler {
    public static Mono<Throwable> handleCyberSourceResponse(ClientResponse error) {
        return error.bodyToMono(String.class)
                .map(body -> new CyberSourceError(String.valueOf(error.statusCode().value()), body));
    }
}
