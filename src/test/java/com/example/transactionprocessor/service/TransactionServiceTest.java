package com.example.transactionprocessor.service;

import Api.CaptureApi;
import Api.PaymentsApi;
import Invokers.ApiException;
import Model.CreatePaymentRequest;
import Model.PtsV2PaymentsCapturesPost201Response;
import Model.PtsV2PaymentsPost201Response;
import Model.PtsV2PaymentsPost201ResponseOrderInformation;
import Model.PtsV2PaymentsPost201ResponseOrderInformationAmountDetails;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
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

        // Return a new mocked Transaction that the same as the one that is passed in
        when(transactionRepository.save(any())).thenAnswer(invocation -> {
            Transaction transaction = invocation.getArgument(0);
            Transaction mockedTransaction = new Transaction();
            mockedTransaction.setReferencePaymentId(transaction.getReferencePaymentId());
            mockedTransaction.setStatus(transaction.getStatus());
            mockedTransaction.setAuthorizedAmount(transaction.getAuthorizedAmount());
            mockedTransaction.setAccountId(transaction.getAccountId());
            mockedTransaction.setId(transaction.getId());
            mockedTransaction.setCreatedAt(transaction.getCreatedAt());
            mockedTransaction.setUpdatedAt(transaction.getUpdatedAt());
            return mockedTransaction;
        });


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
        mockedResponse.setStatus("PENDING");
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
}