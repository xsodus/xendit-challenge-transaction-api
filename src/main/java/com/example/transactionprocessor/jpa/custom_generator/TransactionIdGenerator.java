package com.example.transactionprocessor.jpa.custom_generator;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TransactionIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        // Generate a 22-digit ID based on the current time
        long timestamp = Instant.now().toEpochMilli();
        String id = String.format("%022d", timestamp);
        return Long.valueOf(id);
    }
}
