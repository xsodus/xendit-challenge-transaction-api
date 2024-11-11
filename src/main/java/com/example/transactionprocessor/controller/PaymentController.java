package com.example.transactionprocessor.controller;
import com.example.transactionprocessor.api.PaymentApi;
import com.example.transactionprocessor.dto.request.CreditCardDetail;
import com.example.transactionprocessor.dto.request.ProcessPaymentRequestDTO;
import com.example.transactionprocessor.dto.response.ProcessPaymentResponseDTO;
import com.example.transactionprocessor.mapper.PaymentMapper;
import com.example.transactionprocessor.model.Transaction;
import com.example.transactionprocessor.runtime.error.exception.CyberSourceError;
import com.example.transactionprocessor.runtime.error.exception.InvalidInputError;
import com.example.transactionprocessor.service.AccountService;
import com.example.transactionprocessor.service.TransactionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class PaymentController implements PaymentApi {

    private final TransactionService transactionService;


    private final AccountService accountService;


    private final PaymentMapper paymentMapper;

    public PaymentController(TransactionService transactionService, AccountService accountService,
                             PaymentMapper paymentMapper) {
        this.transactionService = transactionService;
        this.accountService = accountService;
        this.paymentMapper = paymentMapper;
    }

    @Override
    @PostMapping(
            value = "/api/payments",
            produces = "application/json",
            consumes = "application/json"
    )
    public ResponseEntity<ProcessPaymentResponseDTO> processPayment(@RequestBody @Valid
                                      ProcessPaymentRequestDTO processPaymentRequestDTO)
            throws InvalidInputError, CyberSourceError {

        // Validate credit card data in processPaymentRequestDTO
        CreditCardDetail creditCardDetail = processPaymentRequestDTO.getCreditCardDetail();
        String creditCardNumber = creditCardDetail.getNumber();
        String expirationMonth = creditCardDetail.getExpirationMonth();
        String expirationYear = creditCardDetail.getExpirationYear();

        // Validate credit card number format (simple regex for illustration)
        if (!creditCardNumber.matches("\\d{16}")) {
            throw new InvalidInputError("Invalid credit card number");
        }

        // Validate expiration month
        int month = Integer.parseInt(expirationMonth);
        if (month < 1 || month > 12) {
            throw new InvalidInputError("Invalid expiration month");
        }

        // Validate expiration year (simple check for illustration)
        int year = Integer.parseInt(expirationYear);
        if (year < 2023) {
            throw new InvalidInputError("Invalid expiration year");
        }

        // Validate email address format inside processPaymentRequestDTO
        String email = processPaymentRequestDTO.getBillingDetail().getEmail();
        if (!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
            throw new InvalidInputError("Invalid email address");
        }

        // Validate postal code format inside processPaymentRequestDTO
        String postCode = processPaymentRequestDTO.getBillingDetail().getPostalCode();
        if (!postCode.matches("^\\d{5}$")) {
            throw new InvalidInputError("Invalid postal code");
        }

        // Valid the accountId in processPaymentRequestDTO does exist in the system
        var account = accountService.getAccountById(processPaymentRequestDTO.getAccountId());
        if (!account.isPresent()) {
            throw new InvalidInputError("Account not found");
        }

        // Authorize the payment
        Transaction transaction = transactionService.authorizeTransaction(account.get(),processPaymentRequestDTO);
        // Asynchronously settle the payment
        transactionService.settleTransaction(transaction.getId());
        return ResponseEntity.ok(paymentMapper.toProcessPaymentResponseDTO(transaction));
    }

}
