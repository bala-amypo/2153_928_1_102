package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {

        if (product.getModelNumber() == null || product.getModelNumber().isBlank()) {
            throw new IllegalArgumentException("Model number required");
        }

        if (product.getCategory() == null || product.getCategory().isBlank()) {
            throw new IllegalArgumentException("Category required");
        }

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
