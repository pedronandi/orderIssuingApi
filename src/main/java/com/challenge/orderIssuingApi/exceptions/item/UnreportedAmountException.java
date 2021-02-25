package com.challenge.orderIssuingApi.exceptions.item;

public class UnreportedAmountException extends RuntimeException {
    public UnreportedAmountException(String productName) {
        super("A quantidade informada para o produto " + productName + " deve ser maior que zero!");
    }
}
