package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "alert_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique ID of the alert", example = "1")
    private Long id;

    @NotBlank(message = "Message cannot be empty")
    @Schema(description = "Alert message", example = "CPU usage high")
    private String message;

    @Schema(description = "Creation timestamp", example = "2025-12-19T14:30:00")
    private LocalDateTime SendAt;

    // Automatically set createdAt before saving
    @PrePersist
    protected void onCreate() {
        if (this.SendAt == null) {
            this.SendAt = LocalDateTime.now();
        }
    }
}
