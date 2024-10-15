package com.cmddotenter.StudentClubManagementSystem.controller;

import com.cmddotenter.StudentClubManagementSystem.dto.request.AssignClubEventRequest;
import com.cmddotenter.StudentClubManagementSystem.entity.ClubEvent;
import com.cmddotenter.StudentClubManagementSystem.service.ClubEventServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClubEventController {

    private ClubEventServiceImpl clubEventServiceImpl;

    public ClubEventController(ClubEventServiceImpl clubEventServiceImpl) {
        this.clubEventServiceImpl = clubEventServiceImpl;
    }

    // Endpoint to assign a club to an event
    @PostMapping("/club-event")
    public ResponseEntity<ClubEvent> assignClubToEvent(AssignClubEventRequest request) {
        // Call the service to assign the club to the event
        ClubEvent clubEvent = clubEventServiceImpl.assignClubToEvent(request);

        // Return the created ClubEvent object as a response
        return ResponseEntity.ok(clubEvent);
    }


}
