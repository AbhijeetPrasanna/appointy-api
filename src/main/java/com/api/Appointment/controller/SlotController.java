package com.api.Appointment.controller;



import com.api.Appointment.dto.AvailableSlotsRequest;
import com.api.Appointment.service.SlotService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping("/available-slots")
    public List<String> getAvailableSlots(@RequestBody AvailableSlotsRequest request) {
        LocalDate date = LocalDate.parse(request.getDate());
        LocalTime start = LocalTime.parse(request.getStartTime());
        LocalTime end = LocalTime.parse(request.getEndTime());
        int duration = (request.getSlotDurationMinutes() == null) ? 30 : request.getSlotDurationMinutes();
        return slotService.generateAvailableSlots(date, start, end, duration);
    }
}

