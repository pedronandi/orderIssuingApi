package com.challenge.orderIssuingApi.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;

    public String name;

    public double unitPrice;

    public Integer multiple;

    public Product() {

    }

    public Product(String name, double unitPrice, Integer multiple) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.multiple = multiple;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public Integer getMultiple() {
        return multiple;
    }

    @Override
    public boolean equals(Object object) {
        if(object == this)
            return true;

        if(!(object instanceof Product))
            return false;

        Product product = (Product) object;
        Optional<Integer> thisMultiple = Optional.ofNullable(multiple);
        Optional<Integer> productMultiple = Optional.ofNullable(product.multiple);

        return name.equals(product.name)
                && Double.compare(unitPrice, product.unitPrice) == 0
                && thisMultiple.equals(productMultiple);
    }
}