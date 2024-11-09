package com.example.transactionprocessor.service;

import com.example.transactionprocessor.model.Account;
import com.example.transactionprocessor.repository.AccountRepository;
import com.example.transactionprocessor.repository.TransactionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    // Implement a function to fetch account by accountId
    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }

    // Implement a function to create account by accountId
    public Account createAccountById(Long accountId) {
        Account account = new Account();
        account.setAccountId(accountId);
        return accountRepository.save(account);
    }
}
