package com.challenge.orderIssuingApi.exceptions.item;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UnreportedUnitPriceAdvice {

    @ResponseBody
    @ExceptionHandler(UnreportedUnitPriceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String unreportedUnitPriceHandler(UnreportedUnitPriceException ex) {
        return ex.getMessage();
    }
}
