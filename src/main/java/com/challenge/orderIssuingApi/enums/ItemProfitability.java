package com.challenge.orderIssuingApi.enums;

public enum ItemProfitability {
    GREAT("Ótima"),
    GOOD("Boa"),
    BAD("Ruim");

    private String itemProfitability;

    ItemProfitability(String itemProfitability) {
        this.itemProfitability = itemProfitability;
    }

    public String getItemProfitability() {
        return itemProfitability;
    }
}
