package com.example.transactionprocessor.repository;

import com.example.transactionprocessor.model.Account;

import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {

    // This function will ensure that the account balance is updated correctly in high concurrency scenarios
    @Modifying
    @Transactional
    @Query("UPDATE Account a SET a.balance = a.balance + :amount WHERE a.id = :accountId")
    int addAmountToBalance(Long accountId, BigDecimal amount);

}
