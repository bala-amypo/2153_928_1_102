package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.WarrantyService;

@Service
public class WarrantyServiceImpl implements WarrantyService {

    private final WarrantyRepository warrantyRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;

    public WarrantyServiceImpl(WarrantyRepository warrantyRepo,
                               UserRepository userRepo,
                               ProductRepository productRepo) {
        this.warrantyRepo = warrantyRepo;
        this.userRepo = userRepo;
        this.productRepo = productRepo;
    }

    @Override
    public Warranty registerWarranty(Long userId, Long productId, Warranty warranty) {

        if (warrantyRepo.existsBySerialNumber(warranty.getSerialNumber())) {
            throw new RuntimeException("Serial number must be unique");
        }

        if (!warranty.getExpiryDate().isAfter(warranty.getPurchaseDate())) {
            throw new RuntimeException("Expiry date must be after purchase date");
        }

        warranty.setUser(userRepo.findById(userId).orElseThrow());
        warranty.setProduct(productRepo.findById(productId).orElseThrow());

        return warrantyRepo.save(warranty);
    }

    @Override
    public Warranty getWarranty(Long warrantyId) {
        return warrantyRepo.findById(warrantyId).orElseThrow();
    }

    @Override
    public List<Warranty> getUserWarranties(Long userId) {
        return warrantyRepo.findByUserId(userId);
    }
}
