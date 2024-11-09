package com.example.transactionprocessor.dto.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class BillingDetail {
    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String address1;

    @NonNull
    private String locality;

    @NonNull
    private String administrativeArea;

    @NonNull
    private String postalCode;

    @NonNull
    private String country;

    @NonNull
    private String email;

    @NonNull
    private String phoneNumber;
}
