package com.example.demo.repository;

import com.example.demo.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {

    boolean existsBySerialNumber(String serialNumber);

    List<Warranty> findByUserId(Long userId);

    List<Warranty> findWarrantiesExpiringBetween(LocalDate start, LocalDate end);
}
