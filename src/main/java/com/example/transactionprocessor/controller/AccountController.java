package com.example.transactionprocessor.controller;

import com.example.transactionprocessor.api.AccountApi;
import com.example.transactionprocessor.model.Account;
import com.example.transactionprocessor.model.Transaction;
import com.example.transactionprocessor.repository.AccountRepository;
import com.example.transactionprocessor.service.TransactionService;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController implements AccountApi {

    private final AccountRepository accountRepository;

    private final TransactionService transactionService;

    public AccountController(AccountRepository accountRepository,
                             TransactionService transactionService) {
        this.accountRepository = accountRepository;
        this.transactionService = transactionService;
    }

    @Override
    @GetMapping(value = "/{accountId}", produces = {"application/json"} )
    public ResponseEntity<Account> getAccountData(Long accountId) {
        // fetch account by accountId from Account Service and return 404 if not found
        var account = accountRepository.findById(accountId);
        if(account.isPresent()){
            return ResponseEntity.ok(account.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @PutMapping(value = "/{accountId}", produces = {"application/json"} )
    public ResponseEntity<Account> createAccountData(Long accountId) {
        // Create account by accountId from Account Service and return bad request status if account already exists
        var account = accountRepository.findById(accountId);
        if(account.isPresent()){
            return ResponseEntity.badRequest().build();
        } else {
            Account newAccount = new Account();
            newAccount.setAccountId(accountId);
            accountRepository.save(newAccount);
            return ResponseEntity.ok(newAccount);
        }
    }

    @Override
    @GetMapping(
            value = "/{accountId}/transactions",
            produces = "application/json"
    )
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable("accountId") Long accountId) {
        var transactions = transactionService.getTransactionsByAccountId(accountId);
        if (transactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transactions);
    }
}
