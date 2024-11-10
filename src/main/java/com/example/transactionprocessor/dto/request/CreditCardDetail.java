package com.example.transactionprocessor.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NonNull;

@Schema(
        description = "Credit card detail"
)
@Data
public class CreditCardDetail {
    @Schema(
            description = "Credit card number",
            example = "4111111111111111"
    )
    @NonNull
    private String number;

    @Schema(
            description = "Credit card expiration month",
            example = "12"
    )
    @NonNull
    private String expirationMonth;

    @Schema(
            description = "Credit card expiration year",
            example = "2031"
    )
    @NonNull
    private String expirationYear;
}