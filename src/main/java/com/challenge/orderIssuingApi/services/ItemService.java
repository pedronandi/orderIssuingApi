package com.challenge.orderIssuingApi.services;

import com.challenge.orderIssuingApi.models.Item;
import com.challenge.orderIssuingApi.models.OrderRequest;

import java.util.List;

public interface ItemService {

    public void validate(Item item);

    public Item save(Item item);

    public void setOrderRequest(Item item, OrderRequest orderRequest);

    public void deleteById(Integer id);

    public void deleteAll(List<Item> items);
}