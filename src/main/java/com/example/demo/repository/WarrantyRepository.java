package com.example.demo.repository;

import com.example.demo.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WarrantyRepository extends JpaRepository<Warranty, Long> {

    // Find warranties for a specific user
    List<Warranty> findByUserId(Long userId);

    // Find warranties with a specific status
    List<Warranty> findByStatus(String status);

    // Check if a warranty exists by serial number
    boolean existsBySerialNumber(String serialNumber);

    // Find warranties expiring between two dates
    List<Warranty> findByExpiryDateBetween(LocalDate start, LocalDate end);
}
