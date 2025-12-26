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

    @PostMapping("/{userId}/{productId}")
    public Warranty register(
            @PathVariable Long userId,
            @PathVariable Long productId,
            @RequestBody Warranty warranty) {
        return service.registerWarranty(userId, productId, warranty);
    }

    @GetMapping("/user/{userId}")
    public List<Warranty> getByUser(@PathVariable Long userId) {
        return service.getUserWarranties(userId);
    }

    @GetMapping("/{id}")
    public Warranty getById(@PathVariable Long id) {
        return service.getWarranty(id);
    }
}
