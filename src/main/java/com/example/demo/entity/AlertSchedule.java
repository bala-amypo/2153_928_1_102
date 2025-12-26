package com.example.demo.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertSchedule {
    private Long id;
    private Integer daysBeforeExpiry;
    private Boolean enabled;
}
