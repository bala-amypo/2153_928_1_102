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

    private String alertMessage;
    private LocalDateTime alertTime;

    @ManyToOne
    private Warranty warranty;

    public void prePersist() {
        this.alertTime = LocalDateTime.now();
    }
}
