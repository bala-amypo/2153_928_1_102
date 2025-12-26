package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.WarrantyService;
import org.springframework.stereotype.Service;

import java.util.List;

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

        User user = userRepo.findById(userId).orElseThrow();
        Product product = productRepo.findById(productId).orElseThrow();

        warranty.setUser(user);
        warranty.setProduct(product);

        if (warranty.getPurchaseDate() != null && product.getWarrantyPeriodMonths() != null) {
            warranty.setExpiryDate(
                    warranty.getPurchaseDate().plusMonths(product.getWarrantyPeriodMonths())
            );
        }

        warranty.setStatus("ACTIVE");
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
