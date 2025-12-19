package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.Warranty;
import com.example.demo.service.WarrantyService;

@RestController
@RequestMapping("/warranties")
public class WarrantyController {
    private final WarrantyService service;
    public WarrantyController(WarrantyService service){ this.service = service; }

    @PostMapping("/add")
    public Warranty addWarranty(@RequestBody Warranty w){ return service.saveWarranty(w); }

    @GetMapping("/all")
    public List<Warranty> getWarranties(){ return service.getAllWarranties(); }

    @GetMapping("/{id}")
    public Warranty getWarranty(@PathVariable Long id){ return service.getWarrantyById(id); }

    @DeleteMapping("/{id}")
    public String deleteWarranty(@PathVariable Long id){
        service.deleteWarranty(id);
        return "Deleted successfully";
    }
}

