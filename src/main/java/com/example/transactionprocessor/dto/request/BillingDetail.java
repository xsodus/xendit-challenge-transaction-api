package com.example.transactionprocessor.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NonNull;

@Schema(
        description = "Billing detail"
)
@Data
public class BillingDetail {

    @Schema(
            description = "First name",
            example = "John"
    )
    @NonNull
    private String firstName;

    @Schema(
            description = "Last name",
            example = "Doe"
    )
    @NonNull
    private String lastName;

    @Schema(
            description = "Address 1",
            example = "1 Market St"
    )
    @NonNull
    private String address1;

    @Schema(
            description = "Address 2",
            example = "san francisco"
    )
    @NonNull
    private String locality;

    @Schema(
            description = "City",
            example = "CA"
    )
    @NonNull
    private String administrativeArea;

    @Schema(
            description = "Postal code",
            example = "94105"
    )
    @NonNull
    private String postalCode;

    @Schema(
            description = "Country",
            example = "US"
    )
    @NonNull
    private String country;

    @Schema(
            description = "Email Address",
            example = "test@cybs.com"
    )
    @NonNull
    private String email;

    @Schema(
            description = "Phone number",
            example = "4158880000"
    )
    @NonNull
    private String phoneNumber;
}
