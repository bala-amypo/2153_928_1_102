package com.example.demo.dto;

public class AlertScheduleDTO {

    private Integer daysBeforeExpiry;
    private Boolean enabled;

    public AlertScheduleDTO() {}

    public Integer getDaysBeforeExpiry() {
        return daysBeforeExpiry;
    }
 
    public void setDaysBeforeExpiry(Integer daysBeforeExpiry) {
        this.daysBeforeExpiry = daysBeforeExpiry;
    }
 
    public Boolean getEnabled() {
        return enabled;
    }
 
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
