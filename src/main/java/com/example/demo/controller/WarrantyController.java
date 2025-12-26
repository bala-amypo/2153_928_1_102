package com.example.demo.controller;

import com.example.demo.entity.Warranty;
import com.example.demo.service.impl.WarrantyServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warranties")
public class WarrantyController {

    private final WarrantyServiceImpl service;

    public WarrantyController(WarrantyServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/register/{userId}/{productId}")
    public Warranty registerWarranty(@PathVariable Long userId,
                                     @PathVariable Long productId,
                                     @RequestBody Warranty warranty) {
        return service.registerWarranty(userId, productId, warranty);
    }

    @GetMapping("/{warrantyId}")
    public Warranty getWarranty(@PathVariable Long warrantyId) {
        return service.getWarranty(warrantyId);
    }

    @GetMapping("/user/{userId}")
    public List<Warranty> getUserWarranties(@PathVariable Long userId) {
        return service.getUserWarranties(userId);
    }
}
