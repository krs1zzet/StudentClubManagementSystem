package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.entity.Events;
import com.cmddotenter.StudentClubManagementSystem.repo.ClubRepository;
import com.cmddotenter.StudentClubManagementSystem.repo.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    private final EventRepository eventRepository;

    private final ClubRepository clubRepository;

    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public Events create(String name, String date, String description) {
        Club club = clubRepository.findByName(name);
        if(club==null){
            club = new Club();
            club.setName(name);
            clubRepository.save(club);
        }
        Events event = new Events(name, date, description, club);
        return eventRepository.save(event);
    }

    @Override
    public Events findByName(String name) {
        return eventRepository.findByName(name);
    }

    @Override
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);

    }

    @Override
    public List<Events> getAllEvents() {
        return eventRepository.findAll();
    }
}
