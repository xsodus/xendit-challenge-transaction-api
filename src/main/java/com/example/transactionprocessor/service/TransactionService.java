package com.example.transactionprocessor.service;
import com.example.transactionprocessor.model.Transaction;
import com.example.transactionprocessor.repository.AccountRepository;
import com.example.transactionprocessor.repository.TransactionRepository;
import java.math.BigDecimal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    private AccountRepository accountRepository;
    public Transaction authorizeTransaction(Long accountId, BigDecimal amount) { Transaction transaction = new Transaction(); transaction.setAccountId(accountId);
        transaction.setAmount(amount);
        transaction.setStatus("AUTHORIZED");
        return transactionRepository.save(transaction);
    }

    // Implement a function to fetch all transactions by accountId
    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    @Async("asyncExecutor")
    public void settleTransaction(Long transactionId) {
        try {
            // Simulate delay for settlement
            Thread.sleep(5000);
            Transaction transaction = transactionRepository.findById(transactionId).orElseThrow();
            transaction.setStatus("SETTLED");
            transactionRepository.save(transaction);
            // Update the balance of the account.
            accountRepository.addAmountToBalance(transaction.getAccountId(), transaction.getAmount());
        } catch (Exception e) {
            log.error("Error while settling transaction!");
            e.printStackTrace();
        }
    }
}