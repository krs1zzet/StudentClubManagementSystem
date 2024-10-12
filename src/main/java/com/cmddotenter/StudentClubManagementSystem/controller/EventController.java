package com.cmddotenter.StudentClubManagementSystem.controller;

import com.cmddotenter.StudentClubManagementSystem.dto.EventDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateEventRequest;
import com.cmddotenter.StudentClubManagementSystem.entity.Event;
import com.cmddotenter.StudentClubManagementSystem.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {
    private static final Logger log = LoggerFactory.getLogger(EventController.class);
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
    public ResponseEntity<Void> createEvent(@RequestBody CreateEventRequest request) {
        eventService.save(request);
        log.info("Event added");
        return ResponseEntity.ok().build();
    }

    @PutMapping("/events")
    public ResponseEntity<Void> updateEvent(@RequestBody CreateEventRequest request) {
        eventService.save(request);
        log.info("Event updated");
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/events/{eventId}")
    public void deleteEvent(@PathVariable long eventId) {
        eventService.deleteById(eventId);
    }

//    @PostMapping("/events/{eventId}/users/{userId}")
//    public EventDTO addUserToEvent(@PathVariable Long eventId, @PathVariable Long userId) {
//        return eventService.addUserToEvent(eventId, userId);
//    }


}