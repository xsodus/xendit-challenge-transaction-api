package com.example.transactionprocessor.service;
import Api.CaptureApi;
import Api.PaymentsApi;
import Invokers.ApiException;
import Model.PtsV2PaymentsPost201Response;
import com.example.transactionprocessor.dto.request.ProcessPaymentRequestDTO;
import com.example.transactionprocessor.mapper.PaymentMapper;
import com.example.transactionprocessor.model.Transaction;
import com.example.transactionprocessor.repository.AccountRepository;
import com.example.transactionprocessor.repository.TransactionRepository;
import com.example.transactionprocessor.runtime.error.CyberSourceApiErrorHandler;
import com.example.transactionprocessor.runtime.error.exception.CyberSourceError;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;

import org.openapitools.client.model.CreatePaymentRequest;
import org.openapitools.client.model.PtsV2PaymentsPost201Response2;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;


@Slf4j
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final AccountRepository accountRepository;

    private final PaymentsApi paymentsApi;

    private final CaptureApi captureApi;

    private final PaymentMapper paymentMapper;

    public TransactionService(TransactionRepository transactionRepository,
                              AccountRepository accountRepository,
                              PaymentsApi paymentsApi,
                              CaptureApi captureApi,
                                PaymentMapper paymentMapper
    ) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.paymentsApi = paymentsApi;
        this.captureApi = captureApi;
        this.paymentMapper = paymentMapper;
    }

    public Transaction authorizeTransaction(ProcessPaymentRequestDTO processPaymentRequestDTO) throws CyberSourceError {

        // Create a new transaction to generate the unique transactionId before sending the request to CyberSource
        Transaction transaction = new Transaction();
        transaction.setAccountId(processPaymentRequestDTO.getAccountId());
        transaction.setAmount(processPaymentRequestDTO.getAmount());
        transaction.setCurrency(processPaymentRequestDTO.getCurrency());
        transaction = transactionRepository.save(transaction);

        // Create a new request with CreatePaymentRequest that maps with processPaymentRequestDTO
        PtsV2PaymentsPost201Response response = null;
        try {
            response = paymentsApi.createPayment(paymentMapper.toCreatePaymentRequestForSimpleAuthorization(processPaymentRequestDTO));
        } catch (ApiException e) {
            throw new CyberSourceError(String.valueOf(e.getCode()),e.getMessage());
        }

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