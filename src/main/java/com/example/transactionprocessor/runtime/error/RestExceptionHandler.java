package com.example.transactionprocessor.runtime.error;

import com.example.transactionprocessor.runtime.error.constant.Errors;
import com.example.transactionprocessor.runtime.error.exception.CyberSourceError;
import com.example.transactionprocessor.runtime.error.exception.InvalidInputError;
import com.example.transactionprocessor.runtime.error.rest.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> generalError(final Exception e) {
        log.error("Unhandled exception occured", e);
        return new ResponseEntity<>(
                new ApiError(
                        Errors.GENERAL_ERROR.val(),
                        e.getMessage()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(CyberSourceError.class)
    public ResponseEntity<ApiError> cyberSourceError(final CyberSourceError e) {
        log.debug("Http response status is {}", HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<>(
                new ApiError(
                       Errors.CYBER_SOURCE_ERROR.val(),
                        e.getErrorDetails()
                ),
                HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    @ExceptionHandler(InvalidInputError.class)
    public ResponseEntity<ApiError> invlidInputError(final InvalidInputError e) {
        log.debug("Http response status is {}", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(
                new ApiError(
                        Errors.GENERAL_ERROR.val(),
                        e.getMessage()
                ),
                HttpStatus.BAD_REQUEST
        );
    }
}
