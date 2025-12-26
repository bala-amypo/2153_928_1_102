package com.example.demo.service.impl;

import com.example.demo.entity.Warranty;
import com.example.demo.entity.User;
import com.example.demo.entity.Product;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.WarrantyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarrantyServiceImpl implements WarrantyService {

    private final WarrantyRepository warrantyRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public WarrantyServiceImpl(WarrantyRepository warrantyRepository,
                               UserRepository userRepository,
                               ProductRepository productRepository){
        this.warrantyRepository = warrantyRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Warranty registerWarranty(Long userId, Long productId, Warranty warranty){
        if(!warranty.getExpiryDate().isAfter(warranty.getPurchaseDate())){
            throw new IllegalArgumentException("Expiry date must be after purchase date");
        }

        if(warrantyRepository.existsBySerialNumber(warranty.getSerialNumber())){
            throw new IllegalArgumentException("Serial number must be unique");
        }

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        warranty.setUser(user);
        warranty.setProduct(product);

        return warrantyRepository.save(warranty);
    }

    @Override
    public List<Warranty> getUserWarranties(Long userId){
        return warrantyRepository.findByUserId(userId);
    }

    @Override
    public Warranty getWarranty(Long id){
        return warrantyRepository.findById(id).orElseThrow(() -> new RuntimeException("Warranty not found"));
    }
}
