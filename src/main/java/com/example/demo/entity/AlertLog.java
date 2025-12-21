package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

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
    private Long id;

    // Each log belongs to a warranty
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "warranty_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Warranty warranty;

    // Log message
    @NotBlank(message = "Message cannot be empty")
    @Column(nullable = false)
    private String message;

    // Auto-generated timestamp
    @Column(name = "sent_at", nullable = false)
    private LocalDateTime sentAt;

    // Auto-set timestamp
    @PrePersist
    protected void onCreate() {
        this.sentAt = LocalDateTime.now();
    }
}
