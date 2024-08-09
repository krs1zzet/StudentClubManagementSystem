package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.controller.dto.CreateEventDto;
import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.entity.Event;
import com.cmddotenter.StudentClubManagementSystem.repo.ClubRepository;
import com.cmddotenter.StudentClubManagementSystem.repo.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    private final ClubService clubService;
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public EventServiceImpl(EventRepository theEventRepository, ClubRepository theClubRepository, ClubService clubService){
        eventRepository = theEventRepository;
        clubRepository = theClubRepository;
        this.clubService = clubService;
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event findById(long theId) {
        Optional<Event> result = eventRepository.findById(theId);
        Event theEvent = null;
        if(result.isPresent()){
            theEvent = result.get();
        }
        else{
            throw new RuntimeException("Did not find event id - " + theId);
        }
        return theEvent;
    }


    //how to make shorter this operation

    @Transactional
    @Override
    public Event save(CreateEventDto theEvent) {
        Club existingClub = clubService.findById(theEvent.getClubId());
        Event theEventEntity = new Event();
        theEventEntity.setClub(existingClub);
        theEventEntity.setName(theEvent.getName());
        theEventEntity.setDescription(theEvent.getDescription());
        theEventEntity.setDate(theEvent.getDate());
        return eventRepository.save(theEventEntity);
    }



    @Transactional
    @Override
    public void deleteById(long theId) {
        eventRepository.deleteById(theId);
    }
}
