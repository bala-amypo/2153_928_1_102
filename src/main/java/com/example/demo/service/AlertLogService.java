package com.example.demo.service;

import com.example.demo.entity.AlertLog;
import java.util.List;

public interface AlertLogService {
    AlertLog saveAlert(AlertLog log);
    List<AlertLog> getAllAlerts();
    AlertLog getAlertById(Long id);
    void deleteAlert(Long id);
}
