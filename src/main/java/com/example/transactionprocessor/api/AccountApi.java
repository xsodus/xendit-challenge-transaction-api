package com.example.transactionprocessor.api;

import com.example.transactionprocessor.model.Account;

import com.example.transactionprocessor.model.Transaction;
import com.example.transactionprocessor.runtime.error.exception.InvalidInputError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface AccountApi {

    @Operation(summary = "Get account data by account id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Results are ok"),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content)})
    ResponseEntity<Account> getAccountData(@PathVariable("accountId") Long accountId) throws InvalidInputError;

    @Operation(summary = "Create account data by account id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Results are ok"),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content)})
    ResponseEntity<Account> createAccountData(@PathVariable("accountId") Long accountId) throws InvalidInputError;

    @Operation(summary = "Get transactions by account id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Results are ok"),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content)})
    ResponseEntity<List<Transaction>> getTransactions(@PathVariable("accountId") Long accountId)
            throws InvalidInputError;

}
