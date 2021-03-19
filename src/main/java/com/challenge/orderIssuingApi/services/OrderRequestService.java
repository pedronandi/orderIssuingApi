package com.challenge.orderIssuingApi.services;

import com.challenge.orderIssuingApi.models.OrderRequest;

import java.util.List;
import java.util.Optional;

public interface OrderRequestService {

    public OrderRequest save(OrderRequest orderRequest);

    public List<OrderRequest> getAll();

    public Optional<OrderRequest> getById(Integer id);

    public OrderRequest update(Integer id, OrderRequest newOrderRequest);
}
