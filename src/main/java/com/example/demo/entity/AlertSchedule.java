package com.example.demo.entity;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class AlertSchedule {
    private Long id;
    private Integer daysBeforeExpiry;
    private Boolean enabled;
}
