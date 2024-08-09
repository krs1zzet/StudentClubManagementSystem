package com.cmddotenter.StudentClubManagementSystem.controller;

import com.cmddotenter.StudentClubManagementSystem.controller.dto.CreateEventDto;
import com.cmddotenter.StudentClubManagementSystem.entity.Event;
import com.cmddotenter.StudentClubManagementSystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {
    private EventService eventService;


    @Autowired
    public EventController(EventService theEventService) {
        eventService = theEventService;
    }

    @GetMapping("/events")
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @PostMapping("/events")
    public Event addEvent(@RequestBody CreateEventDto event) {

        return eventService.save(event);
    }


}
