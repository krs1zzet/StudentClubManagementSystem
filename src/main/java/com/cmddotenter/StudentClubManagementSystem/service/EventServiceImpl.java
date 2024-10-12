package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.ClubDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.Converter.EventDtoConverter;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateEventRequest;
import com.cmddotenter.StudentClubManagementSystem.dto.EventDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.entity.Event;
import com.cmddotenter.StudentClubManagementSystem.repo.EventRepository;
import com.cmddotenter.StudentClubManagementSystem.repo.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventDtoConverter eventDtoConverter;


    @Autowired
    public EventServiceImpl( EventDtoConverter eventDtoConverter, EventRepository theEventRepository, ClubService clubService, UserRepository userRepository) {
        eventRepository = theEventRepository;;
        this.eventDtoConverter = eventDtoConverter;

    }

    @Override
    public List<EventDTO> findAll() {
        return eventDtoConverter.convert(eventRepository.findAll()) ;
    }

    @Override
    public EventDTO findById(long theId) {
        Optional<Event> result = eventRepository.findById(theId);
        Event theEvent = result.orElseThrow(() -> new RuntimeException("Did not find event id - " + theId));
        return eventDtoConverter.convert(theEvent);
    }

    @Transactional
    @Override
    public void save(CreateEventRequest request) {
        Event theEvent = new Event();
        theEvent.setName(request.getName());
        theEvent.setDescription(request.getDescription());
        theEvent.setDate(request.getDate());
        eventRepository.save(theEvent);
    }

    @Transactional
    @Override
    public void deleteById(long theId) {
        eventRepository.deleteById(theId);
    }









}