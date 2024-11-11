package com.example.transactionprocessor.api;

import com.example.transactionprocessor.dto.request.ProcessPaymentRequestDTO;
import com.example.transactionprocessor.dto.response.ProcessPaymentResponseDTO;
import com.example.transactionprocessor.model.Transaction;
import com.example.transactionprocessor.runtime.error.exception.CyberSourceError;
import com.example.transactionprocessor.runtime.error.exception.InvalidInputError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentApi {

    @Operation(summary = "Process payment with CyberSource SDK.",
            description = "Please call PUT /api/accounts/{accountId} to create an account before this api." +
            "After procceeding the payment, you can check the account balance through GET /api/accounts/{accountId}.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Results are ok"),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content)})
    ResponseEntity<ProcessPaymentResponseDTO> processPayment(ProcessPaymentRequestDTO processPaymentRequestDTO)
            throws InvalidInputError, CyberSourceError;

}
