package com.challenge.orderIssuingApi.models;

import com.challenge.orderIssuingApi.enums.ItemProfitability;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    private Product product;

    private int amount;

    private double unitPrice;

    @Enumerated(EnumType.STRING)
    private ItemProfitability profitability;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_request_id")
    private OrderRequest orderRequest;

    public Item() {

    }

    public Item(Product product, int amount, double unitPrice, ItemProfitability profitability, OrderRequest orderRequest) {
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.profitability = profitability;
        this.orderRequest = orderRequest;
    }

    public int getId() {
        return id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setProfitability(ItemProfitability profitability) {
        this.profitability = profitability;
    }

    public ItemProfitability getProfitability() {
        return profitability;
    }

    public void setOrderRequest(OrderRequest orderRequest) {
        this.orderRequest = orderRequest;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }
}
