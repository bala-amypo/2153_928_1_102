package com.example.demo.service;

import com.example.demo.entity.Product;
import java.util.List;


@service 
public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProducts();
}
