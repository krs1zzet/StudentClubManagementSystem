package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.entity.ClubEvent;
import com.cmddotenter.StudentClubManagementSystem.entity.Event;
import com.cmddotenter.StudentClubManagementSystem.repo.ClubEventRepository;
import com.cmddotenter.StudentClubManagementSystem.repo.ClubRepository;
import com.cmddotenter.StudentClubManagementSystem.repo.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class ClubEventService {

    private final ClubEventRepository clubEventRepository;

    private final ClubRepository clubRepository;

    private final EventRepository eventRepository;

    public ClubEventService(ClubEventRepository clubEventRepository, ClubRepository clubRepository, EventRepository eventRepository) {
        this.clubEventRepository = clubEventRepository;
        this.clubRepository = clubRepository;
        this.eventRepository = eventRepository;
    }

    // Method to assign a club to an event
    public ClubEvent assignClubToEvent(Long clubId, Long eventId) {
        // Fetch the Club entity using the clubId
        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> new RuntimeException("Club not found"));

        // Fetch the Event entity using the eventId
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        // Create ClubEvent using Club and Event entities
        ClubEvent clubEvent = ClubEvent.builder()
                .club(club)
                .event(event)
                .build();

        return clubEventRepository.save(clubEvent);
    }
}

