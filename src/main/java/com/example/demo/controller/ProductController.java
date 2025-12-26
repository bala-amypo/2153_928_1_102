package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.service.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product add(@RequestBody ProductDTO dto) {
        Product p = Product.builder()
                .name(dto.getName())
                .brand(dto.getBrand())
                .modelNumber(dto.getModelNumber())
                .category(dto.getCategory())
                .build();
        return productService.addProduct(p);
    }

    @GetMapping
    public List<Product> list() {
        return productService.getAllProducts();
    }
}
