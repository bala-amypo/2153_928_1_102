package com.example.demo.repository;

import com.example.demo.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {
    List<Warranty> findByUserId(Long userId);
}
