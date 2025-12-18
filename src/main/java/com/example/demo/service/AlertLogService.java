package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AlertLog;

public interface AlertLogService {
    AlertLog addLog(Long warrantyId, String message);
    List<AlertLog> getLogs(Long warrantyId);
}
