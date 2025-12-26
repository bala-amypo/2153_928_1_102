package com.example.demo.repository;

import com.example.demo.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {

    List<Warranty> findByUserId(Long userId);

    boolean existsBySerialNumber(String serialNumber);

    @Query("""
           SELECT w FROM Warranty w
           WHERE w.expiryDate BETWEEN :from AND :to
           """)
    List<Warranty> findWarrantiesExpiringBetween(
            @Param("from") LocalDate from,
            @Param("to") LocalDate to
    );
}
