package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import com.example.demo.entity.AlertLog;
import com.example.demo.service.AlertLogService;

@RestController
@RequestMapping("/alerts")
public class AlertLogController {

    private final AlertLogService service;

    public AlertLogController(AlertLogService service) {
        this.service = service;
    }

    // @Valid ensures validation is triggered
    @PostMapping("/add")
    public AlertLog addAlert(@Valid @RequestBody AlertLog log) {
        return service.saveAlert(log);
    }

    @GetMapping("/all")
    public List<AlertLog> getAlerts() {
        return service.getAllAlerts();
    }
}
