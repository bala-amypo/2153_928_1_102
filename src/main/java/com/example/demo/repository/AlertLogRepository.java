package com.example.demo.repository;

import com.example.demo.entity.AlertLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AlertLogRepository extends JpaRepository<AlertLog, Long> {

    List<AlertLog> findByWarrantyId(Long warrantyId);
}
