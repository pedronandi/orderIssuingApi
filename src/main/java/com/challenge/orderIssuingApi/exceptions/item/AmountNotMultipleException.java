package com.challenge.orderIssuingApi.exceptions.item;

public class AmountNotMultipleException extends RuntimeException {
    public AmountNotMultipleException(String productName) {
        super("O produto " + productName + " consta em um item onde a quantidade informada não é múltipla deste produto.");
    }
}
