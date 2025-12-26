package com.example.demo.controller;

import com.example.demo.entity.AlertLog;
import com.example.demo.service.impl.AlertLogServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
@Tag(name = "Alert Logs")
public class AlertLogController {

    private final AlertLogServiceImpl logService;

    public AlertLogController(AlertLogServiceImpl logService) {
        this.logService = logService;
    }

    @PostMapping("/{warrantyId}")
    @Operation(summary = "Add alert log")
    public AlertLog addLog(@PathVariable Long warrantyId,
                           @RequestParam String message) {
        return logService.addLog(warrantyId, message);
    }

    @GetMapping("/{warrantyId}")
    @Operation(summary = "Get alert logs")
    public List<AlertLog> getLogs(@PathVariable Long warrantyId) {
        return logService.getLogs(warrantyId);
    }
}
