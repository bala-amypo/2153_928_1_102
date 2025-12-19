package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/add")
    public Product addProduct(@Valid @RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }
}
