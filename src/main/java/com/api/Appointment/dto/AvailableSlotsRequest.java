package com.api.Appointment.dto;

public class AvailableSlotsRequest {
    private String date;         // "2025-10-30"
    private String startTime;    // "09:00"
    private String endTime;      // "17:00"
    private Integer slotDurationMinutes; // optional, 30 default

    public AvailableSlotsRequest() {}

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public Integer getSlotDurationMinutes() { return slotDurationMinutes; }
    public void setSlotDurationMinutes(Integer slotDurationMinutes) { this.slotDurationMinutes = slotDurationMinutes; }
}