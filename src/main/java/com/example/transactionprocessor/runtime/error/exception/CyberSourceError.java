package com.example.transactionprocessor.runtime.error.exception;

import lombok.Getter;

@Getter
public class CyberSourceError extends Exception {
    private final String errorCode;
    private final String errorDetails;

    public CyberSourceError(String errorCode, String errorDetails) {
        super(errorDetails);
        this.errorCode = errorCode;
        this.errorDetails = errorDetails;
    }

}
