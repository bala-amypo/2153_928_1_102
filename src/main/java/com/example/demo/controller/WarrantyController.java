package com.example.demo.controller;

import com.example.demo.entity.Warranty;
import com.example.demo.service.WarrantyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warranties")
public class WarrantyController {

    private final WarrantyService service;

    public WarrantyController(WarrantyService service) {
        this.service = service;
    }

    // POST /warranties/register/{userId}/{productId}
    @PostMapping("/register/{userId}/{productId}")
    public Warranty registerWarranty(
            @PathVariable Long userId,
            @PathVariable Long productId,
            @RequestBody Warranty warranty) {

        return service.registerWarranty(warranty);
    }

    // GET /warranties/{warrantyId}
    @GetMapping("/{warrantyId}")
    public Warranty getWarranty(@PathVariable Long warrantyId) {
        return service.getWarrantyById(warrantyId);
    }

    // GET /warranties/user/{userId}
    @GetMapping("/user/{userId}")
    public List<Warranty> getUserWarranties(
            @PathVariable Long userId) {
        return service.getWarrantiesByUser(userId);
    }
}
