package com.example.projectvoucher.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@RestControllerAdvice
public class ApiControllerAdvice {
    private static final Logger log = LoggerFactory.getLogger(ApiControllerAdvice.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResponse handleIllegalArgumentException(final IllegalArgumentException e) {
        log.info(Arrays.toString(e.getStackTrace()));
        return new ErrorResponse(e.getMessage(), LocalDateTime.now(), UUID.randomUUID());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public ErrorResponse handleIllegalStateException(final IllegalStateException e) {
        log.info(Arrays.toString(e.getStackTrace()));
        return new ErrorResponse(e.getMessage(), LocalDateTime.now(), UUID.randomUUID());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(final Exception e) {
        log.error(Arrays.toString(e.getStackTrace()));
        return new ErrorResponse(e.getMessage(), LocalDateTime.now(), UUID.randomUUID());
    }
}
