package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Warranty;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {}
