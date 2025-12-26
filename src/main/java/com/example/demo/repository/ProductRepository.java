package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find product by name
    Optional<Product> findByName(String name);

    // Check if product exists by serial number
    boolean existsBySerialNumber(String serialNumber);
}
