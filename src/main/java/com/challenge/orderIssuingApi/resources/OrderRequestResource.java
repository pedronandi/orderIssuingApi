package com.challenge.orderIssuingApi.resources;

import com.challenge.orderIssuingApi.models.OrderRequest;
import com.challenge.orderIssuingApi.services.OrderRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/orderRequest")
public class OrderRequestResource {

    private OrderRequestService orderRequestService;

    public OrderRequestResource(OrderRequestService orderRequestService) {
        this.orderRequestService = orderRequestService;
    }

    @PostMapping
    public ResponseEntity<OrderRequest> save(@RequestBody OrderRequest orderRequest) {
        try {
            return new ResponseEntity<>(orderRequestService.save(orderRequest), HttpStatus.OK);
        } catch(Exception e) {
            throw new ResponseStatusException(e.hashCode(), e.getMessage(), e);
        }
    }

    @GetMapping
    public ResponseEntity<List<OrderRequest>> getAll() {
        return new ResponseEntity<>(orderRequestService.getAll(), HttpStatus.OK);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<OrderRequest> update(@PathVariable Integer id, @RequestBody OrderRequest newOrderRequest) {
        try {
            return new ResponseEntity<>(orderRequestService.update(id, newOrderRequest), HttpStatus.OK);
        } catch(NoSuchElementException nsee) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}