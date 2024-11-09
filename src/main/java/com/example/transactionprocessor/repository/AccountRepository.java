package com.example.transactionprocessor.repository;

import com.example.transactionprocessor.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
