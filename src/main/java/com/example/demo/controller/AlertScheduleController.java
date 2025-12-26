package com.example.demo.controller;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.AlertScheduleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class AlertScheduleController {

    private final AlertScheduleService service;

    public AlertScheduleController(AlertScheduleService service) {
        this.service = service;
    }

    @PostMapping("/{warrantyId}")
    public ResponseEntity<AlertSchedule> createSchedule(
            @PathVariable Long warrantyId,
            @Valid @RequestBody AlertSchedule schedule) {

        return ResponseEntity.ok(
                service.createSchedule(warrantyId, schedule)
        );
    }

    @GetMapping("/{warrantyId}")
    public ResponseEntity<List<AlertSchedule>> getSchedules(
            @PathVariable Long warrantyId) {

        return ResponseEntity.ok(service.getSchedules(warrantyId));
    }
}
