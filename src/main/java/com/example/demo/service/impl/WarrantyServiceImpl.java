// src/main/java/com/example/demo/service/impl/WarrantyServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.entity.Warranty;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class WarrantyServiceImpl implements WarrantyService {
    
    @Autowired
    private WarrantyRepository warrantyRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    public WarrantyServiceImpl(WarrantyRepository warrantyRepository, 
                              UserRepository userRepository, 
                              ProductRepository productRepository) {
        this.warrantyRepository = warrantyRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }
    
    @Override
    public Warranty registerWarranty(Long userId, Long productId, Warranty warranty) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
        
        // Validate serial number uniqueness
        if (warrantyRepository.existsBySerialNumber(warranty.getSerialNumber())) {
            throw new IllegalArgumentException("Serial number must be unique: " + warranty.getSerialNumber());
        }
        
        // Validate dates
        if (warranty.getExpiryDate().isBefore(warranty.getPurchaseDate()) || 
            warranty.getExpiryDate().isEqual(warranty.getPurchaseDate())) {
            throw new IllegalArgumentException("Expiry date must be after purchase date");
        }
        
        warranty.setUser(user);
        warranty.setProduct(product);
        
        return warrantyRepository.save(warranty);
    }
    
    @Override
    public List<Warranty> getUserWarranties(Long userId) {
        return warrantyRepository.findByUserId(userId);
    }
    
    @Override
    public Warranty getWarranty(Long id) {
        return warrantyRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Warranty not found with id: " + id));
    }
    
    public List<Warranty> getWarrantiesExpiringBetween(LocalDate startDate, LocalDate endDate) {
        return warrantyRepository.findWarrantiesExpiringBetween(startDate, endDate);
    }
}