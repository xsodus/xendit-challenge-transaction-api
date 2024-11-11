package com.example.transactionprocessor.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    private Long id;
    private BigDecimal balance = BigDecimal.ZERO;

    @OneToMany(
        mappedBy = "account",
        cascade = CascadeType.ALL
    )
    private List<Transaction> transactions;
}
