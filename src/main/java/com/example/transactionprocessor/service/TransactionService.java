package com.example.transactionprocessor.service;
import com.example.transactionprocessor.model.Transaction;
import com.example.transactionprocessor.repository.TransactionRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    public Transaction authorizeTransaction(Long accountId, BigDecimal amount) { Transaction transaction = new Transaction(); transaction.setAccountId(accountId);
        transaction.setAmount(amount);
        transaction.setStatus("AUTHORIZED");
        return transactionRepository.save(transaction); }
    @Async("asyncExecutor")
    public void settleTransaction(Long transactionId) {
        try {

            // Simulate delay for settlement
            Thread.sleep(5000);
            Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(); transaction.setStatus("SETTLED");
            transactionRepository.save(transaction);
            // Here you would update the balance of the account.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}