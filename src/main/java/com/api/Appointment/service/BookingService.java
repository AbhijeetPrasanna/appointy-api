package com.api.Appointment.service;



import com.api.Appointment.entity.Booking;
import com.api.Appointment.exception.SlotUnavailableException;
import com.api.Appointment.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking bookSlot(LocalDate date, LocalTime startTime, Integer durationMinutes, Long userId) {
        // check double booking
        boolean exists = bookingRepository.existsByDateAndStartTime(date, startTime);
        if (exists) {
            throw new SlotUnavailableException("Slot already booked at " + startTime + " on " + date);
        }
        Booking booking = new Booking(date, startTime, durationMinutes, userId);
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingsByDate(LocalDate date) {
        return bookingRepository.findByDate(date);
    }
}
