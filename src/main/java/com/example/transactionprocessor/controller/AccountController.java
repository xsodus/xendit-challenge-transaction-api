package com.example.transactionprocessor.controller;

import com.example.transactionprocessor.api.AccountApi;
import com.example.transactionprocessor.dto.response.AccountResponseDTO;
import com.example.transactionprocessor.dto.response.ProcessPaymentResponseDTO;
import com.example.transactionprocessor.mapper.PaymentMapper;
import com.example.transactionprocessor.model.Account;
import com.example.transactionprocessor.model.Transaction;
import com.example.transactionprocessor.repository.AccountRepository;
import com.example.transactionprocessor.runtime.error.exception.InvalidInputError;
import com.example.transactionprocessor.service.TransactionService;
import java.util.List;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController implements AccountApi {

    private final AccountRepository accountRepository;

    private final TransactionService transactionService;


    private final PaymentMapper paymentMapper;

    public AccountController(AccountRepository accountRepository,
                             TransactionService transactionService,
                             PaymentMapper paymentMapper) {
        this.accountRepository = accountRepository;
        this.transactionService = transactionService;
        this.paymentMapper = paymentMapper;
    }

    @Override
    @GetMapping(value = "/{accountId}", produces = {"application/json"} )
    public ResponseEntity<AccountResponseDTO> getAccountData(Long accountId) throws InvalidInputError {
        // fetch account by accountId from Account Service and return 404 if not found
        var account = accountRepository.findById(accountId);
        if(account.isPresent()){
            AccountResponseDTO responseDTO = new AccountResponseDTO();
            // Map responseDTO with Account data
            responseDTO.setId(account.get().getId());
            responseDTO.setBalance(account.get().getBalance());
            return ResponseEntity.ok(responseDTO);
        } else {
            throw new InvalidInputError("Account not found!");
        }
    }

    @Override
    @PostMapping(value = "/{accountId}", produces = {"application/json"} )
    public ResponseEntity<Account> createAccountData(Long accountId) throws InvalidInputError {
        // Create account by accountId from Account Service and return bad request status if account already exists
        var account = accountRepository.findById(accountId);
        if(account.isPresent()){
            throw new InvalidInputError("The account already exists!");
        } else {
            Account newAccount = new Account();
            newAccount.setId(accountId);
            accountRepository.save(newAccount);
            return ResponseEntity.ok(newAccount);
        }
    }

    @Override
    @GetMapping(
            value = "/{accountId}/transactions",
            produces = "application/json"
    )
    public ResponseEntity<List<ProcessPaymentResponseDTO>> getTransactions(@PathVariable("accountId") Long accountId)
            throws InvalidInputError {
        var account = accountRepository.findById(accountId);
        if (account.isEmpty()) {
            throw new InvalidInputError("No transactions found for the account");
        }

        // Map transactions to ProcessPaymentResponseDTO
        List<ProcessPaymentResponseDTO> responseDTOs = account.get()
                .getTransactions()
                .stream()
                .map(paymentMapper::toProcessPaymentResponseDTO)
                .toList();

        return ResponseEntity.ok(responseDTOs);
    }
}
