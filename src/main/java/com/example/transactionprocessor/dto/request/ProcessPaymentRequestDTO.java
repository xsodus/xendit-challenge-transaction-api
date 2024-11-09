package com.example.transactionprocessor.dto.request;

import java.math.BigDecimal;
import lombok.Data;
import lombok.NonNull;

@Data
public class ProcessPaymentRequestDTO {
    @NonNull
    private Long accountId;

    @NonNull
    private BigDecimal amount;

    @NonNull
    private CreditCardDetail creditCardDetail;

    @NonNull
    private BillingDetail billingDetail;

}
