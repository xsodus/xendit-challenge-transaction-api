package com.example.transactionprocessor.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ApplicationConfig {
    @Value("${spring.application.api-retry.initial-interval}")
    private long baseDelay;
    @Value("${spring.application.api-retry.max-interval}")
    private long maxDelay;
    @Value("${spring.application.api-retry.max-attempts}")
    private int maxRetry;
}
