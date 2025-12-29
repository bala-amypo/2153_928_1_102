package com.example.demo.controller;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.AlertScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Remove these lines:
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;
// @Tag(name = "Alert Schedules", description = "Alert Schedule management APIs")

// Remove: @Tag(name = "Alert Schedules", description = "Alert Schedule management APIs")
@RestController
@RequestMapping("/api/schedules")
public class AlertScheduleController {
    
    @Autowired
    private AlertScheduleService scheduleService;
    
    // Remove: @Operation(summary = "Create a new alert schedule")
    @PostMapping("/warranty/{warrantyId}")
    public ResponseEntity<AlertSchedule> createSchedule(
            @PathVariable Long warrantyId,
            @RequestBody AlertSchedule schedule) {
        AlertSchedule created = scheduleService.createSchedule(warrantyId, schedule);
        return ResponseEntity.ok(created);
    }
    
    
    @GetMapping("/warranty/{warrantyId}")
    public ResponseEntity<List<AlertSchedule>> getSchedules(@PathVariable Long warrantyId) {
        List<AlertSchedule> schedules = scheduleService.getSchedules(warrantyId);
        return ResponseEntity.ok(schedules);
    }
}