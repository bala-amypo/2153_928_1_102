package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.AlertSchedule;

public interface AlertScheduleRepository extends JpaRepository<AlertSchedule, Long> {}
