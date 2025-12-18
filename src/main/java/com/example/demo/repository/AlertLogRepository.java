package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.AlertLog;

public interface AlertLogRepository extends JpaRepository<AlertLog, Long> {}
