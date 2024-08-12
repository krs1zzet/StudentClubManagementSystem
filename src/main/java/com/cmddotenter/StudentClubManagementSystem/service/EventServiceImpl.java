package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.ClubDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.EventDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.entity.Event;
import com.cmddotenter.StudentClubManagementSystem.entity.User;
import com.cmddotenter.StudentClubManagementSystem.repo.EventRepository;
import com.cmddotenter.StudentClubManagementSystem.repo.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final ClubService clubService;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired
    public EventServiceImpl(EventRepository theEventRepository, ClubService clubService, UserRepository userRepository) {
        eventRepository = theEventRepository;
        this.clubService = clubService;
        this.userRepository = userRepository;
    }

    @Override
    public List<EventDTO> findAll() {
        return eventRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public EventDTO findById(long theId) {
        Optional<Event> result = eventRepository.findById(theId);
        Event theEvent = result.orElseThrow(() -> new RuntimeException("Did not find event id - " + theId));
        return convertToDTO(theEvent);
    }


/*
*  ekleyecegin rolu bul
*
*
* */

    @Transactional
    @Override
    public EventDTO save(EventDTO theEvent) {
        ClubDTO existingClub = clubService.findById(theEvent.getClubId());
        Event theEventEntity = convertToEntity(theEvent); // DTO olarak gelen datayi entitye ceviriyoruz
        theEventEntity.setClub(new Club(existingClub.getId(), existingClub.getClubName(), existingClub.getClubDescription()));
        return convertToDTO(eventRepository.save(theEventEntity)); // kaydedildigni belirtmek icin return edip ekrana veriyoruz
    }

    @Transactional
    @Override
    public void deleteById(long theId) {
        eventRepository.deleteById(theId);
    }

    @Transactional
    @Override
    public Event addUserToEvent(long eventId, long userId) {
        Event theEvent = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Did not find event id - " + eventId));
        User theUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Did not find user id - " + userId));
        theEvent.setUser(theUser);
        return eventRepository.save(theEvent);
    }

    private EventDTO convertToDTO(Event event) {
        EventDTO eventDTO = new EventDTO();

        eventDTO.setId(event.getId());
        eventDTO.setName(event.getName());
        eventDTO.setDate(event.getDate());
        eventDTO.setDescription(event.getDescription());

        if (event.getClub() != null) {
            eventDTO.setClubId(event.getClub().getId());
        }
        return eventDTO;
    }

    private Event convertToEntity(EventDTO eventDTO) {
        Event event = new Event();
        event.setId(eventDTO.getId());
        event.setName(eventDTO.getName());
        event.setDate(eventDTO.getDate());
        event.setDescription(eventDTO.getDescription());
        return event;
    }
}