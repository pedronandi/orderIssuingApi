package com.challenge.orderIssuingApi.exceptions.item;

public class BadProfitabilityException extends RuntimeException {
    public BadProfitabilityException(String productName) {
        super("A rentabilidade para o produto " + productName + " é ruim. Portanto, não será permitida a venda do mesmo.");
    }
}
