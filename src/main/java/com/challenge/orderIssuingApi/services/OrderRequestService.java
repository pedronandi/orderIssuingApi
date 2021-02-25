package com.challenge.orderIssuingApi.services;

import com.challenge.orderIssuingApi.models.OrderRequest;

import java.util.List;

public interface OrderRequestService {

    public OrderRequest save(OrderRequest orderRequest);

    public List<OrderRequest> getAll();

    public OrderRequest update(Integer id, OrderRequest newOrderRequest);
}
