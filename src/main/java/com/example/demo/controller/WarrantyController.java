package com.example.demo.controller;

import com.example.demo.entity.Warranty;
import com.example.demo.service.WarrantyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warranties")
public class WarrantyController {

    private final WarrantyService warrantyService;

    public WarrantyController(WarrantyService warrantyService) {
        this.warrantyService = warrantyService;
    }

    @PostMapping
    public ResponseEntity<Warranty> createWarranty(@RequestBody Warranty warranty) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(warrantyService.createWarranty(warranty));
    }

    @GetMapping
    public List<Warranty> getAllWarranties() {
        return warrantyService.getAllWarranties();
    }

    @GetMapping("/{id}")
    public Warranty getWarrantyById(@PathVariable Long id) {
        return warrantyService.getWarrantyById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Warranty> getWarrantiesByUser(@PathVariable Long userId) {
        return warrantyService.getWarrantiesByUser(userId);
    }
}
