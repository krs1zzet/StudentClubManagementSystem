package com.cmddotenter.StudentClubManagementSystem.controller;

import com.cmddotenter.StudentClubManagementSystem.dto.EventDTO;
import com.cmddotenter.StudentClubManagementSystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService theEventService) {
        eventService = theEventService;
    }

    @GetMapping("/events")
    public List<EventDTO> findAll() {
        return eventService.findAll();
    }

    @PostMapping("/events")
    public EventDTO addEvent(@RequestBody EventDTO event) {
        return eventService.save(event);
    }

    @PutMapping("/events")
    public EventDTO updateEvent(@RequestBody EventDTO event) {
        return eventService.save(event);
    }

    @DeleteMapping("/events/{eventId}")
    public void deleteEvent(@PathVariable long eventId) {
        eventService.deleteById(eventId);
    }
}