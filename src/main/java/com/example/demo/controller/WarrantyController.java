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

    @PostMapping("/add")
    public Warranty addWarranty(@Valid @RequestBody Warranty warranty){
        return service.saveWarranty(warranty);
    }

    @GetMapping("/all")
    public List<Warranty> getWarranties(){
        return service.getAllWarranties();
    }

    @GetMapping("/{id}")
    public Warranty getWarranty(@PathVariable Long id){
        return service.getWarrantyById(id);
    }
}
