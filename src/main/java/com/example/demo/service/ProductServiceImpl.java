package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        if (product.getModelNumber() == null || product.getModelNumber().isEmpty()) {
            throw new IllegalArgumentException("Model number required");
        }
        if (product.getCategory() == null || product.getCategory().isEmpty()) {
            throw new IllegalArgumentException("Category required");
        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
