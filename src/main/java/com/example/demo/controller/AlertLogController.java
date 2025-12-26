package com.example.demo.controller;

import com.example.demo.dto.AlertLogRequest;
import com.example.demo.entity.AlertLog;
import com.example.demo.service.AlertLogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class AlertLogController {

    private final AlertLogService service;

    public AlertLogController(AlertLogService service) {
        this.service = service;
    }

    @PostMapping("/{warrantyId}")
    public ResponseEntity<AlertLog> addLog(
            @PathVariable Long warrantyId,
            @Valid @RequestBody AlertLogRequest request) {

        return ResponseEntity.ok(
                service.addLog(warrantyId, request.getMessage())
        );
    }

    @GetMapping("/{warrantyId}")
    public ResponseEntity<List<AlertLog>> getLogs(
            @PathVariable Long warrantyId) {

        return ResponseEntity.ok(service.getLogs(warrantyId));
    }
}
