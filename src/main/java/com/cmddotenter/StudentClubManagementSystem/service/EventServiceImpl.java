package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.ClubDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.Converter.EventDtoConverter;
import com.cmddotenter.StudentClubManagementSystem.dto.request.EventEntityConverter;
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

    private final ClubService clubService;
    private final EventRepository eventRepository;
    private final EventDtoConverter eventDtoConverter;
    private final EventEntityConverter eventEntityConverter;
    private final UserRepository userRepository;

    @Autowired
    public EventServiceImpl(EventEntityConverter eventEntityConverter, EventDtoConverter eventDtoConverter, EventRepository theEventRepository, ClubService clubService, UserRepository userRepository) {
        eventRepository = theEventRepository;
        this.clubService = clubService;
        this.eventDtoConverter = eventDtoConverter;
        this.eventEntityConverter = eventEntityConverter;
        this.userRepository = userRepository;
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
    public EventDTO save(EventDTO theEvent) {
        ClubDTO existingClub = clubService.findById(theEvent.getClubId());
        Event theEventEntity = eventEntityConverter.convert(theEvent); // DTO olarak gelen datayi entitye ceviriyoruz
        theEventEntity.setClub(new Club(existingClub.getId(), existingClub.getClubName(), existingClub.getClubDescription()));
        return eventDtoConverter.convert(eventRepository.save(theEventEntity)); // kaydedildigni belirtmek icin return edip ekrana veriyoruz
    }

    @Transactional
    @Override
    public void deleteById(long theId) {
        eventRepository.deleteById(theId);
    }









}