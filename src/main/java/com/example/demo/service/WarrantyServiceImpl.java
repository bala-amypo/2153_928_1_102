package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import com.example.demo.entity.Warranty;
import com.example.demo.entity.User;
import com.example.demo.entity.Product;
import com.example.demo.exception.InvalidExpiryDateException;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.WarrantyService;

@Service
@Transactional
public class WarrantyServiceImpl implements WarrantyService {

    private final WarrantyRepository warrantyRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;

    public WarrantyServiceImpl(WarrantyRepository warrantyRepo,
                               UserRepository userRepo,
                               ProductRepository productRepo){
        this.warrantyRepo = warrantyRepo;
        this.userRepo = userRepo;
        this.productRepo = productRepo;
    }

    @Override
    public Warranty registerWarranty(Long userId, Long productId, Warranty warranty) {

        // Fetch user & product
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Set user & product
        warranty.setUser(user);
        warranty.setProduct(product);

        // Validate expiry date
        if(!warranty.getExpiryDate().isAfter(warranty.getPurchaseDate())){
            throw new InvalidExpiryDateException("Expiry date must be after purchase date");
        }

        return warrantyRepo.save(warranty);
    }

    @Override
    public Warranty getWarrantyById(Long warrantyId){
        return warrantyRepo.findById(warrantyId)
                .orElseThrow(() -> new RuntimeException("Warranty not found"));
    }

    @Override
    public List<Warranty> getWarrantiesByUser(Long userId){
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return warrantyRepo.findByUser(user);
    }
}
