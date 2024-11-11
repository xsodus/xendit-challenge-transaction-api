package com.example.transactionprocessor.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ProcessPaymentResponseDTO {
    @Schema(
            description = "Transaction ID",
            example = "123"
    )
    private Long id;

    @Schema(
            description = "Processing amount",
            example = "102.21"
    )
    private BigDecimal amount = BigDecimal.ZERO;

    @Schema(
            description = "Currency code",
            example = "USD"
    )
    private String currency;

    @Schema(
            description = "Status of the transaction",
            example = "PENDING"
    )
    private String status; // PENDING, AUTHORIZED, SETTLED

    @Schema(
            description = "Account ID",
            example = "123"
    )
    private Long accountId;


    @Schema(
            description = "Reference payment ID",
            example = "123"
    )
    private String referencePaymentId;

    @Schema(
            description = "Created at",
            example = "2021-09-01T12:00:00"
    )
    private LocalDateTime createdAt;

    @Schema(
            description = "Updated at",
            example = "2021-09-01T12:00:00"
    )
    private LocalDateTime updatedAt;
}
