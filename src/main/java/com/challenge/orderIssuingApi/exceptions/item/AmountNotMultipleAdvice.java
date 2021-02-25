package com.challenge.orderIssuingApi.exceptions.item;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AmountNotMultipleAdvice {

    @ResponseBody
    @ExceptionHandler(AmountNotMultipleException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String amountNotMultipleHandler(AmountNotMultipleException ex) {
        return ex.getMessage();
    }
}