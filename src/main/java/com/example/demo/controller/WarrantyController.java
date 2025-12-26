package com.example.demo.controller;

import com.example.demo.dto.WarrantyDTO;
import com.example.demo.entity.Warranty;
import com.example.demo.service.impl.WarrantyServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warranties")
public class WarrantyController {

    private final WarrantyServiceImpl warrantyService;

    public WarrantyController(WarrantyServiceImpl warrantyService) {
        this.warrantyService = warrantyService;
    }

    @PostMapping
    public Warranty register(@RequestBody WarrantyDTO dto) {
        Warranty w = Warranty.builder()
                .purchaseDate(dto.getPurchaseDate())
                .expiryDate(dto.getExpiryDate())
                .serialNumber(dto.getSerialNumber())
                .build();
        return warrantyService.registerWarranty(
                dto.getUserId(),
                dto.getProductId(),
                w
        );
    }

    @GetMapping("/user/{userId}")
    public List<Warranty> getUserWarranties(@PathVariable Long userId) {
        return warrantyService.getUserWarranties(userId);
    }

    @GetMapping("/{id}")
    public Warranty getWarranty(@PathVariable Long id) {
        return warrantyService.getWarranty(id);
    }
}
