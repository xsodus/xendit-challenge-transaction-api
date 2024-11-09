package com.example.transactionprocessor.dto.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreditCardDetail {
    @NonNull
    private String number;

    @NonNull
    private String expirationMonth;

    @NonNull
    private String expirationYear;
}