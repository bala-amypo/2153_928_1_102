package com.example.demo.controller;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.AlertScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alert-schedules")
public class AlertScheduleController {

    private final AlertScheduleService alertScheduleService;

    public AlertScheduleController(AlertScheduleService alertScheduleService) {
        this.alertScheduleService = alertScheduleService;
    }

    // Create Alert Schedule
    @PostMapping
    public ResponseEntity<AlertSchedule> createAlertSchedule(
            @RequestBody AlertSchedule alertSchedule) {

        AlertSchedule saved = alertScheduleService.createAlertSchedule(alertSchedule);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Get All Alert Schedules
    @GetMapping
    public ResponseEntity<List<AlertSchedule>> getAllAlertSchedules() {
        return ResponseEntity.ok(alertScheduleService.getAllAlertSchedules());
    }

    // Get Alert Schedule by ID
    @GetMapping("/{id}")
    public ResponseEntity<AlertSchedule> getAlertScheduleById(@PathVariable Long id) {
        return ResponseEntity.ok(alertScheduleService.getAlertScheduleById(id));
    }

    // Delete Alert Schedule
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlertSchedule(@PathVariable Long id) {
        alertScheduleService.deleteAlertSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
