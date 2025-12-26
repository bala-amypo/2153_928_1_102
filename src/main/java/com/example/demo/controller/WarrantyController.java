// src/main/java/com/example/demo/controller/WarrantyController.java
package com.example.demo.controller;

import com.example.demo.entity.Warranty;
import com.example.demo.service.WarrantyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/warranties")
public class WarrantyController {
    
    @Autowired
    private WarrantyService warrantyService;
    
    @PostMapping("/user/{userId}/product/{productId}")
    public ResponseEntity<Warranty> registerWarranty(
            @PathVariable Long userId,
            @PathVariable Long productId,
            @Valid @RequestBody Warranty warranty) {
        Warranty saved = warrantyService.registerWarranty(userId, productId, warranty);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Warranty>> getUserWarranties(@PathVariable Long userId) {
        List<Warranty> warranties = warrantyService.getUserWarranties(userId);
        return ResponseEntity.ok(warranties);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Warranty> getWarranty(@PathVariable Long id) {
        Warranty warranty = warrantyService.getWarranty(id);
        return ResponseEntity.ok(warranty);
    }
}