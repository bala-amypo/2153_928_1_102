package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class AlertLogController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Alert time is required")
    private LocalDateTime alertTime;

    @NotBlank(message = "Alert message cannot be empty")
    private String alertMessage;

    // getters and setters
}
