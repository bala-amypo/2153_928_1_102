package com.example.demo.entity;

import lombok.*;

import jakarta.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AlertSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer daysBeforeExpiry;
    private Boolean enabled;
}
