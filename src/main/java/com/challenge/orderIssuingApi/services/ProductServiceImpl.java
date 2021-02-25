package com.challenge.orderIssuingApi.services;

import com.challenge.orderIssuingApi.models.Product;
import com.challenge.orderIssuingApi.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean exists(Product newProduct) {
        for (Product product : getAll()) {
            if(product.equals(newProduct))
                return true;
        }

        return false;
    }
}