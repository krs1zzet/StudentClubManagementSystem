package com.cmddotenter.StudentClubManagementSystem.controller;

import com.cmddotenter.StudentClubManagementSystem.entity.ClubEvent;
import com.cmddotenter.StudentClubManagementSystem.service.ClubEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClubEventController {

    private ClubEventService clubEventService;

    public ClubEventController(ClubEventService clubEventService) {
        this.clubEventService = clubEventService;
    }

    // Endpoint to assign a club to an event
    @PostMapping("/club-event")
    public ResponseEntity<ClubEvent> assignClubToEvent(@RequestParam Long clubId, @RequestParam Long eventId) {
        // Call the service to assign the club to the event
        ClubEvent clubEvent = clubEventService.assignClubToEvent(clubId, eventId);

        // Return the created ClubEvent object as a response
        return ResponseEntity.ok(clubEvent);
    }
    @GetMapping("/club-event")
    public ResponseEntity<ClubEvent> getClubEvent(@RequestParam Long clubId, @RequestParam Long eventId) {
        // Call the service to assign the club to the event
        ClubEvent clubEvent = clubEventService.assignClubToEvent(clubId, eventId);

        // Return the created ClubEvent object as a response
        return ResponseEntity.ok(clubEvent);
    }

}
