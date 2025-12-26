package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AlertLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private LocalDateTime alertTime;

    @ManyToOne
    private Warranty warranty;

    // Used to set alert time automatically
    public void prePersist() {
        this.alertTime = LocalDateTime.now();
    }
}
