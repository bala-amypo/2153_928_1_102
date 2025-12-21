package com.example.demo.service.impl;

import com.example.demo.entity.Warranty;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.WarrantyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarrantyServiceImpl implements WarrantyService {

    private final WarrantyRepository repo;

    public WarrantyServiceImpl(WarrantyRepository repo) {
        this.repo = repo;
    }

    @Override
    public Warranty registerWarranty(Warranty warranty) {

        // Rule: Expiry date must be after purchase date
        if (warranty.getExpiryDate().isBefore(warranty.getPurchaseDate())) {
            throw new RuntimeException(
                "Expiry date must be after purchase date"
            );
        }

        // Rule: Serial number must be unique
        if (repo.existsBySerialNumber(warranty.getSerialNumber())) {
            throw new RuntimeException(
                "Serial number must be unique"
            );
        }

        return repo.save(warranty);
    }

    @Override
    public Warranty getWarrantyById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Warranty not found"));
    }

    @Override
    public List<Warranty> getWarrantiesByUser(Long userId) {
        return repo.findByUserId(userId);
    }
}
