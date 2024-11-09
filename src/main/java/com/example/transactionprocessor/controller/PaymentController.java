package com.example.transactionprocessor.controller;
import com.example.transactionprocessor.api.PaymentApi;
import com.example.transactionprocessor.dto.request.CreditCardDetail;
import com.example.transactionprocessor.dto.request.ProcessPaymentRequestDTO;
import com.example.transactionprocessor.model.Transaction;
import com.example.transactionprocessor.service.TransactionService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/payments")
public class PaymentController implements PaymentApi {
    @Autowired
    private TransactionService transactionService;

    @Override
    @PostMapping(
            value = "/{accountId}",
            produces = "application/json",
            consumes = "application/json"
    )
    public ResponseEntity<Transaction> processPayment(@PathVariable("accountId") Long accountId, @RequestBody @Valid
                                      ProcessPaymentRequestDTO processPaymentRequestDTO) {
        // TODO : Validate this logic with unit test

        // Validate credit card data in processPaymentRequestDTO
        CreditCardDetail creditCardDetail = processPaymentRequestDTO.getCreditCardDetail();
        String creditCardNumber = creditCardDetail.getNumber();
        String expirationMonth = creditCardDetail.getExpirationMonth();
        String expirationYear = creditCardDetail.getExpirationYear();

        // Validate credit card number format (simple regex for illustration)
        if (!creditCardNumber.matches("\\d{16}")) {
            return ResponseEntity.badRequest().body(null);
        }

        // Validate expiration month
        int month = Integer.parseInt(expirationMonth);
        if (month < 1 || month > 12) {
            return ResponseEntity.badRequest().body(null);
        }

        // Validate expiration year (simple check for illustration)
        int year = Integer.parseInt(expirationYear);
        if (year < 2023) {
            return ResponseEntity.badRequest().body(null);
        }

        // Validate email address format inside processPaymentRequestDTO
        String email = processPaymentRequestDTO.getBillingDetail().getEmail();
        if (!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
            return ResponseEntity.badRequest().body(null);
        }

        // Validate postal code format inside processPaymentRequestDTO
        String postCode = processPaymentRequestDTO.getBillingDetail().getPostalCode();
        if (!postCode.matches("^\\d{5}$")) {
            return ResponseEntity.badRequest().body(null);
        }

        // Authorize the payment
        Transaction transaction = transactionService.authorizeTransaction(accountId, processPaymentRequestDTO.getAmount());
        // Asynchronously settle the payment
        transactionService.settleTransaction(transaction.getId());
        return ResponseEntity.ok(transaction);
    }

    @Override
    @GetMapping(
            value = "/{accountId}",
            produces = "application/json"
    )
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable("accountId") Long accountId) {
        return ResponseEntity.ok(transactionService.getTransactionsByAccountId(accountId));
    }

}
