package com.example.transactionprocessor.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NonNull;

@Data
public class PaymentProcessingInformation {
    @Schema(
            description = "Capture the payment",
            example = "true"
    )
    @NonNull
    private Boolean capture;

    @Schema(
            description = "Commerce indicator",
            example = "internet"
    )
    @NonNull
    private String commerceIndicator;
}
