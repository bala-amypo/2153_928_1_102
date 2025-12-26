package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.WarrantyService;

import java.util.List;
@Service
public class WarrantyServiceImpl implements WarrantyService {

    private final WarrantyRepository warrantyRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;

    public WarrantyServiceImpl(WarrantyRepository w, UserRepository u, ProductRepository p) {
        this.warrantyRepo = w;
        this.userRepo = u;
        this.productRepo = p;
    }

    public Warranty registerWarranty(Long userId, Long productId, Warranty w) {

        if (!w.getExpiryDate().isAfter(w.getPurchaseDate()))
            throw new IllegalArgumentException("Expiry date must be after purchase date");

        if (warrantyRepo.existsBySerialNumber(w.getSerialNumber()))
            throw new IllegalArgumentException("Serial number must be unique");

        w.setUser(userRepo.findById(userId).orElseThrow(RuntimeException::new));
        w.setProduct(productRepo.findById(productId).orElseThrow(RuntimeException::new));

        return warrantyRepo.save(w);
    }

    public List<Warranty> getUserWarranties(Long userId) {
        return warrantyRepo.findByUserId(userId);
    }

    public Warranty getWarranty(Long id) {
        return warrantyRepo.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
