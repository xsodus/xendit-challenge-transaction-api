package com.example.transactionprocessor.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class AccountResponseDTO {

    @Schema(
            description = "Account ID",
            example = "123"
    )
    private Long id;

    @Schema(
            description = "Account balance",
            example = "102.21"
    )
    private BigDecimal balance = BigDecimal.ZERO;
}
