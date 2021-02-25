package com.challenge.orderIssuingApi.exceptions.item;

public class UnreportedUnitPriceException extends RuntimeException {
    public UnreportedUnitPriceException(String productName) {
        super("O preço unitário informado para o produto " + productName + " deve ser maior que zero!");
    }
}