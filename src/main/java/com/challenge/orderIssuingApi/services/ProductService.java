package com.challenge.orderIssuingApi.services;

import com.challenge.orderIssuingApi.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product save(Product product);

    public List<Product> getAll();

    public Optional<Product> getById(Integer id);

    public boolean exists(Product newProduct);
}
