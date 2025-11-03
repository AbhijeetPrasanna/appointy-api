package com.api.Appointment.dto;

public class BookingRequest {
    private String date;        // "2025-10-30"
    private String startTime;   // "10:00"
    private Integer durationMinutes; // e.g., 30
    private Long userId;        // optional

    public BookingRequest() {}

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public Integer getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
