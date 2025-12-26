package com.example.demo.repository;

import com.example.demo.entity.Warranty;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WarrantyRepository {
    boolean existsBySerialNumber(String serialNumber);
    Warranty save(Warranty warranty);
    Optional<Warranty> findById(Long id);
    List<Warranty> findByUserId(Long userId);
    List<Warranty> findWarrantiesExpiringBetween(LocalDate start, LocalDate end);
}
