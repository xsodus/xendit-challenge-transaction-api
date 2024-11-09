package com.example.transactionprocessor.runtime.error.constant;

public enum Errors {

    UNKNOWN_ERROR("API_UNKNOWN_ERROR"),
    GENERAL_ERROR("API_GENERAL_ERROR"),
    CYBER_SOURCE_ERROR("API_CYBER_SOURCE_ERROR");

    public final String code;

    private Errors(String code) {
        this.code = code;
    }

    public String val() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }


}
