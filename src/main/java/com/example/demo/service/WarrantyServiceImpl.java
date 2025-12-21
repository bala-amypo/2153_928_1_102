package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.entity.Warranty;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.WarrantyService;

@Service
public class WarrantyServiceImpl implements WarrantyService {
    private final WarrantyRepository repo;
    public WarrantyServiceImpl(WarrantyRepository repo){ this.repo = repo; }

    @Override
    public Warranty saveWarranty(Warranty w){ return repo.save(w); }

    @Override
    public List<Warranty> getAllWarranties(){ return repo.findAll(); }

    @Override
    public Warranty getWarrantyById(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException("Warranty not found")); }

    
}
