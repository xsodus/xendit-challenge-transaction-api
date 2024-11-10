package com.example.transactionprocessor.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NonNull;

@Schema(
        description = "Process payment request"
)
@Data
public class ProcessPaymentRequestDTO {
    @Schema(
            description = "Account ID",
            example = "123"
    )
    @NonNull
    private Long accountId;

    @Schema(
            description = "Processing amount",
            example = "102.21"
    )
    @NonNull
    private BigDecimal amount;

    @Schema(
            description = "Currency code",
            example = "USD"
    )
    @NonNull
    private String currency;

    @NonNull
    private CreditCardDetail creditCardDetail;

    @NonNull
    private BillingDetail billingDetail;

}
