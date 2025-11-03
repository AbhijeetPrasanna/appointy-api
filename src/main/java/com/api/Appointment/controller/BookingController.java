package com.api.Appointment.controller;



import com.api.Appointment.dto.BookingRequest;
import com.api.Appointment.entity.Booking;
import com.api.Appointment.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book-slot")
    public Booking bookSlot(@RequestBody BookingRequest request) {
        LocalDate date = LocalDate.parse(request.getDate());
        LocalTime start = LocalTime.parse(request.getStartTime());
        Integer duration = (request.getDurationMinutes() == null) ? 30 : request.getDurationMinutes();
        return bookingService.bookSlot(date, start, duration, request.getUserId());
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/by-date")
    public List<Booking> getByDate(@RequestParam String date) {
        return bookingService.getBookingsByDate(LocalDate.parse(date));
    }
}
