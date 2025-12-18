package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){ this.productService = productService; }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product p){ return productService.saveProduct(p); }

    @GetMapping("/all")
    public List<Product> getProducts(){ return productService.getAllProducts(); }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){ return productService.getProductById(id); }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Deleted successfully";
    }
}
