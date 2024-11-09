package com.example.transactionprocessor.api;

import com.example.transactionprocessor.model.Account;

import com.example.transactionprocessor.model.Transaction;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface AccountApi {
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Results are ok"),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "404", description = "resource not found", content = @Content)})
    ResponseEntity<Account> getAccountData(@PathVariable("accountId") Long accountId);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Results are ok"),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "404", description = "resource not found", content = @Content)})
    ResponseEntity<Account> createAccountData(@PathVariable("accountId") Long accountId);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Results are ok"),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "404", description = "resource not found", content = @Content)})
    ResponseEntity<List<Transaction>> getTransactions(@PathVariable("accountId") Long accountId);

}
