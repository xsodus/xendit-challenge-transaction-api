package com.example.transactionprocessor.controller;
import com.example.transactionprocessor.model.Transaction;
import com.example.transactionprocessor.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping
    public Transaction processPayment(@RequestParam Long accountId, @RequestParam BigDecimal amount) {
        // Authorize the payment
        Transaction transaction = transactionService.authorizeTransaction(accountId, amount);
        // Asynchronously settle the payment
        transactionService.settleTransaction(transaction.getId());
        return transaction;
    }

}
