package com.example.transactionprocessor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.Data;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private Long accountId;
    private BigDecimal amount;
    private String status; // PENDING, AUTHORIZED, SETTLED

}
