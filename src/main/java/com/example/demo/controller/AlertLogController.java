package com.example.demo.controller;

import com.example.demo.entity.AlertLog;
import com.example.demo.service.AlertLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertLogController {

    private final AlertLogService alertLogService;

    public AlertLogController(AlertLogService alertLogService) {
        this.alertLogService = alertLogService;
    }

    @GetMapping
    public List<AlertLog> getAllAlerts() {
        return alertLogService.getAllAlerts();
    }

    @GetMapping("/user/{userId}")
    public List<AlertLog> getAlertsByUser(@PathVariable Long userId) {
        return alertLogService.getAlertsByUser(userId);
    }
}
