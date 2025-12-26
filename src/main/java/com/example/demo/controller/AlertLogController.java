package com.example.demo.controller;

import com.example.demo.entity.AlertLog;
import com.example.demo.service.impl.AlertLogServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class AlertLogController {

    private final AlertLogServiceImpl service;

    public AlertLogController(AlertLogServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/{warrantyId}")
    public AlertLog addLog(@PathVariable Long warrantyId,
                           @RequestBody String message) {
        return service.addLog(warrantyId, message);
    }

    @GetMapping("/{warrantyId}")
    public List<AlertLog> getLogs(@PathVariable Long warrantyId) {
        return service.getLogs(warrantyId);
    }
}
