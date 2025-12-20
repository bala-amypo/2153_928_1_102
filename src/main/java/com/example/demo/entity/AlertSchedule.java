package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Alert_Schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique ID of the schedule", example = "1")
    private Long id;

    @ManyToOne
    @NotNull(message = "Warranty must be provided")
    @Schema(description = "Associated warranty object")
    private Warranty warranty;

    @NotNull(message = "Alert time is required")
    @Schema(description = "Time of the alert", example = "2025-12-20T09:00:00")
    private LocalDateTime alertTime;

    @NotBlank(message = "Alert message cannot be empty")
    @Schema(description = "Message for the alert", example = "Warranty expiring soon")
    private String alertMessage;
}
