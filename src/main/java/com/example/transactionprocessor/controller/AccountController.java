package com.example.transactionprocessor.controller;

import com.example.transactionprocessor.api.AccountApi;
import com.example.transactionprocessor.model.Account;
import com.example.transactionprocessor.repository.AccountRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

public class AccountController implements AccountApi {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public ResponseEntity<Account> getTAccountData(Long accountId) {
        // fetch account by accountId from Account Service and return 404 if not found
        var account = accountRepository.findById(accountId);
        if(account.isPresent()){
            return ResponseEntity.ok(account.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
