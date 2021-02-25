package com.challenge.orderIssuingApi.services;

import com.challenge.orderIssuingApi.models.Item;
import com.challenge.orderIssuingApi.models.OrderRequest;
import com.challenge.orderIssuingApi.repositories.OrderRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderRequestServiceImpl implements OrderRequestService {

    private OrderRequestRepository orderRequestRepository;
    private ItemService itemService;

    public OrderRequestServiceImpl(OrderRequestRepository orderRequestRepository, ItemService itemService) {
        this.orderRequestRepository = orderRequestRepository;
        this.itemService = itemService;
    }

    public void validateItems(List<Item> items) {
        for (Item item : items) {
            try {
                itemService.validate(item);
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public void saveItems(OrderRequest orderRequest) {
        for (Item item : orderRequest.getItems()) {
            itemService.setOrderRequest(item, orderRequest);
            itemService.save(item);
        }
    }

    @Override
    public OrderRequest save(OrderRequest orderRequest) {
        validateItems(orderRequest.getItems());
        orderRequestRepository.save(orderRequest);
        saveItems(orderRequest);

        return orderRequest;
    }

    @Override
    public List<OrderRequest> getAll() {
        return orderRequestRepository.findAll();
    }

    @Override
    public OrderRequest update(Integer id, OrderRequest newOrderRequest) {
        return orderRequestRepository.findById(id)
                .map(orderRequest -> {
                    orderRequest.setClient(newOrderRequest.getClient());
                    itemService.deleteAll(orderRequest.getItems());
                    orderRequest.setItems(newOrderRequest.getItems());

                    return save(orderRequest);
                }).orElseThrow(() -> new NoSuchElementException());
    }
}