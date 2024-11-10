package com.example.transactionprocessor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(indexes = @Index(columnList = "accountId"))
public class Transaction {
    @Id
    @GeneratedValue(generator = "transaction-id-generator")
    @GenericGenerator(name = "transaction-id-generator",
            strategy = "com.example.transactionprocessor.jpa.custom_generator.TransactionIdGenerator")
    private Long id;
    private Long accountId;
    private BigDecimal amount = BigDecimal.ZERO;
    private String currency;

    // Sometime, the amount authorized can be partial of the initial amount
    // So, we need this field to keep track of the authorized amount
    private BigDecimal authorizedAmount = BigDecimal.ZERO;
    private String status; // PENDING, AUTHORIZED, SETTLED
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }


}
