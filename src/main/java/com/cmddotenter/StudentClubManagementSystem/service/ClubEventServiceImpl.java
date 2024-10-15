package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.request.AssignClubEventRequest;
import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.entity.ClubEvent;
import com.cmddotenter.StudentClubManagementSystem.entity.Event;
import com.cmddotenter.StudentClubManagementSystem.repo.ClubEventRepository;
import com.cmddotenter.StudentClubManagementSystem.repo.ClubRepository;
import com.cmddotenter.StudentClubManagementSystem.repo.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class ClubEventServiceImpl {

    private final ClubEventRepository clubEventRepository;

    private final ClubRepository clubRepository;

    private final EventRepository eventRepository;

    public ClubEventServiceImpl(ClubEventRepository clubEventRepository, ClubRepository clubRepository, EventRepository eventRepository) {
        this.clubEventRepository = clubEventRepository;
        this.clubRepository = clubRepository;
        this.eventRepository = eventRepository;
    }

    // Method to assign a club to an event
    public ClubEvent assignClubToEvent(AssignClubEventRequest request) {
        // Fetch the Club entity using the clubId
        Club club = clubRepository.findById(request.getClub().getId())
                .orElseThrow(() -> new RuntimeException("Club not found"));

        // Fetch the Event entity using the eventId
        Event event = eventRepository.findById(request.getEvent().getId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        // Create ClubEvent using Club and Event entities
        ClubEvent clubEvent = ClubEvent.builder()
                .club(club)
                .event(event)
                .build();

        return clubEventRepository.save(clubEvent);
    }
}

