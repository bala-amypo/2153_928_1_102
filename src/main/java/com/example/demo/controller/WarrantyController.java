package com.example.demo.controller;

import com.example.demo.entity.Warranty;
import com.example.demo.service.WarrantyService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warranties")
public class WarrantyController {

    private final WarrantyService service;

    public WarrantyController(WarrantyService service){
        this.service = service;
    }

    // POST /warranties/register/{userId}/{productId} → register warranty
    @PostMapping("/register/{userId}/{productId}")
    public Warranty registerWarranty(
            @PathVariable Long userId,
            @PathVariable Long productId,
            @Valid @RequestBody Warranty warranty) {

        return service.registerWarranty(userId, productId, warranty);
    }

    // GET /warranties/{warrantyId} → get warranty by ID
    @GetMapping("/{warrantyId}")
    public Warranty getWarranty(@PathVariable Long warrantyId){
        return service.getWarrantyById(warrantyId);
    }

    // GET /warranties/user/{userId} → list warranties by user
    @GetMapping("/user/{userId}")
    public List<Warranty> getUserWarranties(@PathVariable Long userId){
        return service.getWarrantiesByUser(userId);
    }
}
