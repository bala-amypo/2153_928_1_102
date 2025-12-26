package com.example.demo.controller;

import com.example.demo.entity.Warranty;
import com.example.demo.service.impl.WarrantyServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warranties")
@Tag(name = "Warranties")
public class WarrantyController {

    private final WarrantyServiceImpl warrantyService;

    public WarrantyController(WarrantyServiceImpl warrantyService) {
        this.warrantyService = warrantyService;
    }

    @PostMapping("/register/{userId}/{productId}")
    @Operation(summary = "Register warranty")
    public Warranty registerWarranty(@PathVariable Long userId,
                                     @PathVariable Long productId,
                                     @RequestBody Warranty warranty) {
        return warrantyService.registerWarranty(userId, productId, warranty);
    }

    @GetMapping("/{warrantyId}")
    @Operation(summary = "Get warranty by ID")
    public Warranty getWarranty(@PathVariable Long warrantyId) {
        return warrantyService.getWarranty(warrantyId);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get warranties by user")
    public List<Warranty> getUserWarranties(@PathVariable Long userId) {
        return warrantyService.getUserWarranties(userId);
