package com.api.Appointment.exception;

import java.time.LocalDateTime;

public class ApiError {
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ApiError() {}

    public ApiError(String message, String details) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public String getMessage() { return message; }
    public String getDetails() { return details; }

    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public void setMessage(String message) { this.message = message; }
    public void setDetails(String details) { this.details = details; }
}

