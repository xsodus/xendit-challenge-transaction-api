package com.example.transactionprocessor.service;
import com.example.transactionprocessor.model.Transaction;
import com.example.transactionprocessor.repository.AccountRepository;
import com.example.transactionprocessor.repository.TransactionRepository;
import java.math.BigDecimal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.client.api.CaptureApi;
import org.openapitools.client.api.PaymentsApi;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Slf4j
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final AccountRepository accountRepository;

    private final PaymentsApi paymentsApi;

    private final CaptureApi captureApi;

    public TransactionService(TransactionRepository transactionRepository,
                              AccountRepository accountRepository,
                              PaymentsApi paymentsApi,
                              CaptureApi captureApi
    ) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.paymentsApi = paymentsApi;
        this.captureApi = captureApi;
    }

    public Transaction authorizeTransaction(Long accountId, BigDecimal amount) {
        //paymentsApi.createPaymentWithResponseSpec();
        Transaction transaction = new Transaction();
        transaction.setAccountId(accountId);
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
            //captureApi.capturePaymentWithResponseSpec();
            Transaction transaction = transactionRepository.findById(transactionId).orElseThrow();
            transaction.setStatus("SETTLED");
            transactionRepository.save(transaction);
            // Update the balance of the account.
            accountRepository.addAmountToBalance(transaction.getAccountId(), transaction.getAuthorizedAmount());
        } catch (Exception e) {
            log.error("Error while settling transaction!");
            e.printStackTrace();
        }
    }
}