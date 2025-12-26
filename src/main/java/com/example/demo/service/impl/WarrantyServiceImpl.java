package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.entity.Warranty;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WarrantyRepository;

import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class WarrantyServiceImpl {

    private final WarrantyRepository warrantyRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public WarrantyServiceImpl(WarrantyRepository warrantyRepository,
                               UserRepository userRepository,
                               ProductRepository productRepository) {
        this.warrantyRepository = warrantyRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public Warranty registerWarranty(Long userId,
                                     Long productId,
                                     Warranty warranty) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        if (!warranty.getExpiryDate()
                .isAfter(warranty.getPurchaseDate())) {
            throw new IllegalArgumentException(
                    "Expiry date must be after purchase date");
        }

        if (warrantyRepository
                .existsBySerialNumber(warranty.getSerialNumber())) {
            throw new IllegalArgumentException(
                    "Serial number must be unique");
        }

        warranty.setUser(user);
        warranty.setProduct(product);

        return warrantyRepository.save(warranty);
    }

    public Warranty getWarranty(Long warrantyId) {
        return warrantyRepository.findById(warrantyId)
                .orElseThrow(() ->
                        new RuntimeException("Warranty not found"));
    }

    public List<Warranty> getUserWarranties(Long userId) {
        return warrantyRepository.findByUserId(userId);
    }
}
