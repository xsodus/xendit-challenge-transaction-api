package com.example.transactionprocessor.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NonNull;

@Data
public class ClientReferenceInformation {

    @Schema(
            description = "Client reference information code",
            example = "TC50171_3"
    )
    @NonNull
    private String code;

}
