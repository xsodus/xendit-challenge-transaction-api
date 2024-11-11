package com.example.transactionprocessor.service;
import Api.CaptureApi;
import Api.PaymentsApi;
import Invokers.ApiException;
import Model.CreatePaymentRequest;
import Model.PtsV2PaymentsPost201Response;
import com.example.transactionprocessor.config.ApplicationConfig;
import com.example.transactionprocessor.dto.request.ProcessPaymentRequestDTO;
import com.example.transactionprocessor.mapper.PaymentMapper;
import com.example.transactionprocessor.model.Transaction;
import com.example.transactionprocessor.repository.AccountRepository;
import com.example.transactionprocessor.repository.TransactionRepository;
import com.example.transactionprocessor.runtime.error.exception.CyberSourceError;
import java.math.BigDecimal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final AccountRepository accountRepository;

    private final PaymentsApi paymentsApi;

    private final CaptureApi captureApi;

    private final PaymentMapper paymentMapper;


    private final ApplicationConfig applicationConfig;

    public TransactionService(TransactionRepository transactionRepository,
                              AccountRepository accountRepository,
                              PaymentsApi paymentsApi,
                              CaptureApi captureApi,
                              PaymentMapper paymentMapper,
                              ApplicationConfig applicationConfig

    ) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.paymentsApi = paymentsApi;
        this.captureApi = captureApi;
        this.paymentMapper = paymentMapper;
        this.applicationConfig = applicationConfig;
    }

    public Transaction authorizeTransaction(ProcessPaymentRequestDTO processPaymentRequestDTO) throws CyberSourceError {
        CreatePaymentRequest requestObj = paymentMapper.toCreatePaymentRequestForSimpleAuthorization(processPaymentRequestDTO);


        // Create a new request with CreatePaymentRequest that maps with processPaymentRequestDTO
        PtsV2PaymentsPost201Response response = null;
        try {
            response = paymentsApi.createPayment(requestObj);
            log.debug("Response from CyberSource Payment API: {}", response);
        } catch (ApiException e) {
            throw new CyberSourceError(String.valueOf(e.getCode()),e.getMessage());
        }

        Transaction transaction = new Transaction();
        transaction.setAccountId(processPaymentRequestDTO.getAccountId());
        transaction.setAmount(processPaymentRequestDTO.getAmount());
        transaction.setCurrency(processPaymentRequestDTO.getCurrency());
        // Set the reference payment id from CyberSource which is auto-generated
        transaction.setReferencePaymentId(response.getId());

        // Update the transaction with the response from CyberSource
        transaction.setAuthorizedAmount(new BigDecimal(response.getOrderInformation().getAmountDetails().getAuthorizedAmount()));
        transaction.setStatus(response.getStatus());

        return transactionRepository.save(transaction);
    }

    // Implement a function to fetch all transactions by accountId
    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    @Async("asyncExecutor")
    public void settleTransaction(Long transactionId) throws CyberSourceError {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow();
        int retryCount = 0;
        while (!"SETTLED".equals(transaction.getStatus()) && retryCount <= applicationConfig.getMaxRetry()) {
            try {
                log.info("Transaction is being captured!: Transaction ID : {}", transactionId);
                // Simulate delay for settlement
                switch (transaction.getStatus()) {
                    case "AUTHORIZED":
                    case "PARTIAL_AUTHORIZED":
                    case "AUTHORIZED_PENDING_REVIEW":
                        var request = paymentMapper.toCapturePaymentRequest(transaction);
                        var response = captureApi.capturePayment(request, transaction.getReferencePaymentId());
                        log.debug("The transaction is captured!: {}", response);

                        transaction.setStatus("SETTLED");
                        transaction = transactionRepository.save(transaction);

                        // Update the balance of the account.
                        accountRepository.addAmountToBalance(transaction.getAccountId(), transaction.getAuthorizedAmount());

                        log.debug("The transaction is settled!: {}", transaction);
                        return;
                    default:
                        log.error("The transaction is not authorized yet!: {}", transaction);
                        return;
                }

            } catch (ApiException e) {
                var status = e.getCode();
                if(status < 500) {
                    // Stop the process because the current transaction is not valid
                    throw new CyberSourceError(String.valueOf(status), e.getMessage());
                }
                log.error("An error occurred while settling transaction with CyberSource API. Transaction ID : {}", transactionId);
                e.printStackTrace();
            } catch (Exception e) {
                log.error("Error while settling transaction. Transaction ID: {}", transactionId);
                e.printStackTrace();
            } finally {
                try {
                    // Retry with exponential backoff delay
                    Thread.sleep(calculateExponentialBackoffDelay(retryCount++));

                    if(retryCount == applicationConfig.getMaxRetry()) {
                        log.error("The transaction is not settled after {} retries. Transaction ID: {}", applicationConfig.getMaxRetry(), transactionId);
                    } else {
                        log.info("Retry to settle the transaction with CyberSource API. Transaction ID: {}", transactionId);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private long calculateExponentialBackoffDelay(int retryCount) {
        long delay = applicationConfig.getBaseDelay() * (1L << retryCount);
        return Math.min(delay, applicationConfig.getMaxDelay());
    }
}