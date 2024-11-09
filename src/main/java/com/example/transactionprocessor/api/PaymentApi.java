package com.example.transactionprocessor.api;

import com.example.transactionprocessor.dto.request.ProcessPaymentRequestDTO;
import com.example.transactionprocessor.model.Transaction;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentApi {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Results are ok"),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "404", description = "resource not found", content = @Content)})
    ResponseEntity<Transaction> processPayment(@PathVariable("accountId") Long accountId, @RequestBody @Valid ProcessPaymentRequestDTO processPaymentRequestDTO);
}
