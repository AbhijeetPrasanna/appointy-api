package com.api.Appointment.repository;

import com.api.Appointment.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByDate(LocalDate date);

    boolean existsByDateAndStartTime(LocalDate date, LocalTime startTime);

    // Optional: find bookings for a date and time range (start between)
    List<Booking> findByDateAndStartTimeBetween(LocalDate date, LocalTime start, LocalTime end);
}

