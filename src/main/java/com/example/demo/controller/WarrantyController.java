package com.example.demo.controller;

import com.example.demo.entity.Warranty;
import com.example.demo.service.WarrantyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warranties")
public class WarrantyController {

    private final WarrantyService service;

    public WarrantyController(WarrantyService service) {
        this.service = service;
    }

    @PostMapping("/register/{userId}/{productId}")
    public ResponseEntity<Warranty> registerWarranty(
            @PathVariable Long userId,
            @PathVariable Long productId,
            @Valid @RequestBody Warranty warranty) {

        return ResponseEntity.ok(
                service.registerWarranty(userId, productId, warranty)
        );
    }

    @GetMapping("/{warrantyId}")
    public ResponseEntity<Warranty> getWarranty(@PathVariable Long warrantyId) {
        return ResponseEntity.ok(service.getWarranty(warrantyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Warranty>> getUserWarranties(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getUserWarranties(userId));
    }
}
