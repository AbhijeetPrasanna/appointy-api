package com.api.Appointment.service;



import com.api.Appointment.entity.Booking;
import com.api.Appointment.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SlotService {

    private final BookingRepository bookingRepository;
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public SlotService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    /**
     * Generate available slots between start and end excluding booked start times.
     * slotDurationMinutes must divide working window reasonably (but we don't enforce).
     */
    public List<String> generateAvailableSlots(LocalDate date, LocalTime start, LocalTime end, int slotDurationMinutes) {
        // fetch booked startTimes for the date
        List<Booking> bookings = bookingRepository.findByDate(date);

        // set of booked start times as LocalTime
        Set<LocalTime> bookedStartTimes = bookings.stream()
                .map(Booking::getStartTime)
                .collect(Collectors.toSet());

        List<String> available = new ArrayList<>();
        LocalTime current = start;
        while (!current.isAfter(end.minusMinutes(slotDurationMinutes))) {
            if (!bookedStartTimes.contains(current)) {
                available.add(current.format(timeFormatter));
            }
            current = current.plusMinutes(slotDurationMinutes);
        }
        return available;
    }
}

