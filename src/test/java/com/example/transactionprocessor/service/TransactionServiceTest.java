package com.example.transactionprocessor.service;

import Api.CaptureApi;
import Api.PaymentsApi;
import Invokers.ApiException;
import Model.CreatePaymentRequest;
import Model.PtsV2PaymentsCapturesPost201Response;
import Model.PtsV2PaymentsPost201Response;
import Model.PtsV2PaymentsPost201ResponseOrderInformation;
import Model.PtsV2PaymentsPost201ResponseOrderInformationAmountDetails;
import com.example.transactionprocessor.config.ApplicationConfig;
import com.example.transactionprocessor.dto.request.BillingDetail;
import com.example.transactionprocessor.dto.request.CreditCardDetail;
import com.example.transactionprocessor.dto.request.ProcessPaymentRequestDTO;
import com.example.transactionprocessor.mapper.PaymentMapper;
import com.example.transactionprocessor.model.Transaction;
import com.example.transactionprocessor.repository.AccountRepository;
import com.example.transactionprocessor.repository.TransactionRepository;
import com.example.transactionprocessor.runtime.error.exception.CyberSourceError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private PaymentsApi paymentsApi;

    @Mock
    private CaptureApi captureApi;

    @Mock
    private PaymentMapper paymentMapper;

    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private ApplicationConfig applicationConfig;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Set the max retry to 3
        when(applicationConfig.getMaxRetry()).thenReturn(3);
        when(applicationConfig.getBaseDelay()).thenReturn(100L);
        when(applicationConfig.getMaxDelay()).thenReturn(1000L);
    }

    @Test
    public void testAuthorizeTransaction() throws CyberSourceError, ApiException {
        Long accountId = 1L;
        BigDecimal amount = new BigDecimal("100.00");

        String currency = "USD";
        String cardNumber = "4111111111111111";
        String cardExpirationMonth = "12";
        String cardExpirationYear = "2023";
        CreditCardDetail creditCardDetail = new CreditCardDetail(cardNumber, cardExpirationMonth, cardExpirationYear);

        String firstName = "John";
        String lastName = "Doe";
        String email = "akkapondev@gmail.com";
        String phoneNumber = "1234567890";
        String address1 = "123 Main";
        String locality = "San Francisco";
        String administrativeArea = "CA";
        String postalCode = "94105";
        String country = "US";
        BillingDetail billingDetail = new BillingDetail(
                firstName,
                lastName,
                email,
                phoneNumber,
                address1,
                locality,
                administrativeArea,
                postalCode,
                country);


        ProcessPaymentRequestDTO requestDTO = new ProcessPaymentRequestDTO(accountId, amount, currency, creditCardDetail, billingDetail);

        CreatePaymentRequest createPaymentRequest = new CreatePaymentRequest();
        PtsV2PaymentsPost201Response response = new PtsV2PaymentsPost201Response();
        response.setId("12345");
        response.setStatus("AUTHORIZED");


        var amountDetails = new PtsV2PaymentsPost201ResponseOrderInformationAmountDetails();
        amountDetails.setAuthorizedAmount("100.00");


        var orderInformation =new PtsV2PaymentsPost201ResponseOrderInformation();
        orderInformation.setAmountDetails(amountDetails);

        response.setOrderInformation(orderInformation);

        response.getOrderInformation().getAmountDetails().setAuthorizedAmount("100.00");

        when(paymentMapper.toCreatePaymentRequestForSimpleAuthorization(any())).thenReturn(createPaymentRequest);
        when(paymentsApi.createPayment(any())).thenReturn(response);
        when(transactionRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));


        Transaction transaction = transactionService.authorizeTransaction(requestDTO);

        assertEquals("12345", transaction.getReferencePaymentId());
        assertEquals("AUTHORIZED", transaction.getStatus());
        assertEquals(new BigDecimal("100.00"), transaction.getAuthorizedAmount());
    }

    @Test
    public void testGetTransactionsByAccountId() {
        Long accountId = 1L;
        List<Transaction> transactions = List.of(new Transaction(), new Transaction());

        when(transactionRepository.findByAccountId(accountId)).thenReturn(transactions);

        List<Transaction> result = transactionService.getTransactionsByAccountId(accountId);

        assertEquals(transactions, result);
    }

    @Test
    public void testSettleTransaction() throws CyberSourceError, ApiException, InterruptedException {
        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setStatus("AUTHORIZED");
        transaction.setReferencePaymentId("12345");
        transaction.setAuthorizedAmount(new BigDecimal("100.00"));

        var mockedResponse =  new PtsV2PaymentsCapturesPost201Response();

        mockedResponse.setStatus("TRANSMITTED");
        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));
        when(captureApi.capturePayment(any(), any())).thenReturn(mockedResponse);
        when(transactionRepository.save(any())).thenReturn(transaction);

        transactionService.settleTransaction(1L);

        verify(transactionRepository, times(1)).save(transaction);
        verify(accountRepository, times(1)).addAmountToBalance(transaction.getAccountId(), transaction.getAuthorizedAmount());
    }

    @Test
    public void testSettleTransactionWithRetry() throws CyberSourceError, ApiException {
        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setStatus("AUTHORIZED");
        transaction.setReferencePaymentId("12345");
        transaction.setAmount(new BigDecimal("100.00"));
        transaction.setCurrency("USD");
        transaction.setAuthorizedAmount(new BigDecimal("100.00"));

        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));

        // Mock the first call to throw ApiException with status 500
        doThrow(new ApiException(500, "Internal Server Error"))
            .doReturn(new PtsV2PaymentsCapturesPost201Response())
            .when(captureApi).capturePayment(any(), any());

        when(transactionRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        transactionService.settleTransaction(1L);

        verify(transactionRepository, times(1)).save(transaction);
        verify(accountRepository, times(1)).addAmountToBalance(transaction.getAccountId(), transaction.getAuthorizedAmount());
        assertEquals("SETTLED", transaction.getStatus());
    }

    @Test
    public void testSettleTransactionWithClientError() throws ApiException {
        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setStatus("AUTHORIZED");
        transaction.setReferencePaymentId("12345");
        transaction.setAuthorizedAmount(new BigDecimal("100.00"));

        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));

        // Mock the call to throw ApiException with status 4xx
        doThrow(new ApiException(400, "Bad Request"))
            .when(captureApi).capturePayment(any(), any());

        assertThrows(CyberSourceError.class, () -> {
            transactionService.settleTransaction(1L);
        });

        verify(transactionRepository, never()).save(transaction);
        verify(accountRepository, never()).addAmountToBalance(any(), any());
    }

    @Test
    public void testSettleTransactionWithInvalidStatus() throws CyberSourceError, ApiException {
        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setStatus("DECLINED");
        transaction.setReferencePaymentId("12345");
        transaction.setAuthorizedAmount(new BigDecimal("100.00"));

        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));

        transactionService.settleTransaction(1L);

        verify(captureApi, never()).capturePayment(any(), any());
        verify(transactionRepository, never()).save(transaction);
        verify(accountRepository, never()).addAmountToBalance(any(), any());
    }

    @Test
    public void testAuthorizeTransactionThrowsCyberSourceError() throws ApiException {
        Long accountId = 1L;
        BigDecimal amount = new BigDecimal("100.00");
        String currency = "USD";
        String cardNumber = "4111111111111111";
        String cardExpirationMonth = "12";
        String cardExpirationYear = "2023";
        CreditCardDetail creditCardDetail = new CreditCardDetail(cardNumber, cardExpirationMonth, cardExpirationYear);

        String firstName = "John";
        String lastName = "Doe";
        String email = "akkapondev@gmail.com";
        String phoneNumber = "1234567890";
        String address1 = "123 Main";
        String locality = "San Francisco";
        String administrativeArea = "CA";
        String postalCode = "94105";
        String country = "US";
        BillingDetail billingDetail = new BillingDetail(
                firstName,
                lastName,
                email,
                phoneNumber,
                address1,
                locality,
                administrativeArea,
                postalCode,
                country);

        ProcessPaymentRequestDTO requestDTO = new ProcessPaymentRequestDTO(accountId, amount, currency, creditCardDetail, billingDetail);

        CreatePaymentRequest createPaymentRequest = new CreatePaymentRequest();

        when(paymentMapper.toCreatePaymentRequestForSimpleAuthorization(any())).thenReturn(createPaymentRequest);
        when(paymentsApi.createPayment(any())).thenThrow(new ApiException(500, "Internal Server Error"));

        assertThrows(CyberSourceError.class, () -> {
            transactionService.authorizeTransaction(requestDTO);
        });
    }
    @Test
    public void testSettleTransactionReachesMaxRetry() throws CyberSourceError, ApiException {
        // Arrange
        Long transactionId = 1L;
        Transaction transaction = new Transaction();
        transaction.setId(transactionId);
        transaction.setStatus("AUTHORIZED");
        transaction.setReferencePaymentId("12345");
        transaction.setAuthorizedAmount(new BigDecimal("100.00"));
        transaction.setAccountId(1L);

        when(transactionRepository.findById(transactionId)).thenReturn(Optional.of(transaction));

        // Mock capturePayment to always throw ApiException with status 500
        when(captureApi.capturePayment(any(), any())).thenThrow(new ApiException(500, "Internal Server Error"));

        // Act
        transactionService.settleTransaction(transactionId);

        var expectedApiCall = 4;

        // Assert
        // Verify that capturePayment was called MAX_RETRY+1 times
        verify(captureApi, times(expectedApiCall)).capturePayment(any(), any());

        // Verify that transactionRepository.save was called MAX_RETRY times
        verify(transactionRepository, never()).save(transaction);

        // Verify that accountRepository.addAmountToBalance was never called
        verify(accountRepository, never()).addAmountToBalance(any(), any());
    }
}
