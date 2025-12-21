package com.example.demo.controller;

import com.example.demo.entity.AlertLog;
import com.example.demo.service.AlertLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertLogController {

    private final AlertLogService alertLogService;

    public AlertLogController(AlertLogService alertLogService) {
        this.alertLogService = alertLogService;
    }

    
    @PostMapping("/add/{warrantyId}")
    public AlertLog addAlert(@PathVariable Long warrantyId,@RequestParam String message) {
        return alertLogService.addLog(warrantyId, message);
    }

    
    @GetMapping("/{warrantyId}")
    public List<AlertLog> getAlerts(@PathVariable Long warrantyId) {
        return alertLogService.getLogs(warrantyId);
    }
}
