package com.example.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "alert_logs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warranty_id", nullable = false)
    private Warranty warranty;

    private LocalDateTime sentAt;

    private String message;

    @PrePersist
    public void prePersist() {
        this.sentAt = LocalDateTime.now();
    }
}
