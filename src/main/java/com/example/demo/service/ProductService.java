package com.example.demo.service;

import com.example.demo.entity.Product;
import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProducts();
}
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String brand;

    @NotBlank(message = "Model number required")
    private String modelNumber;

    @NotBlank(message = "Category required")
    private String category;
}
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

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    
    @PostMapping
    public Product addProduct(@Valid @RequestBody Product product) {
        return productService.saveProduct(product);
    }

   
    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
}
