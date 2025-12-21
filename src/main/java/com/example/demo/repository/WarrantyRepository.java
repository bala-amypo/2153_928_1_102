package com.example.demo.repository;

import com.example.demo.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {

    boolean existsBySerialNumber(String serialNumber);

    List<Warranty> findByUserId(Long userId);

    // ✅ FIXED using JPQL
    @Query("SELECT w FROM Warranty w WHERE w.expiryDate BETWEEN :start AND :end")
    List<Warranty> findWarrantiesExpiringBetween(
            @Param("start") LocalDate start,
            @Param("end") LocalDate end
    );
}
