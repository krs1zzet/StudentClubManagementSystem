package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.ClubDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.EventDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.UserDTO;
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
    public EventDTO addUserToEvent(Long eventId, Long userId) {
        // Find the event by ID, or throw an exception if not found
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Did not find event id - " + eventId));

        // Find the user by ID, or throw an exception if not found
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Did not find user id - " + userId));

        // Add the user to the event's attendees list
        event.getAttendees().add(user);

        // Save the updated event (this also handles the join table update)
        return convertToDTO(eventRepository.save(event));
    }

    public void deleteUserFromEvent(Long eventId, Long userId) {
        // Find the event by ID, or throw an exception if not found
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Did not find event id - " + eventId));

        // Find the user by ID, or throw an exception if not found
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Did not find user id - " + userId));

        // Remove the user from the event's attendees list
        event.getAttendees().remove(user);

        // Save the updated event (this also handles the join table update)
        eventRepository.save(event);
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
        if(event.getAttendees()!=null){
            eventDTO.setAttendees(event.getAttendees().stream().map(this::convertToUserDTO).collect(Collectors.toList()));
        }
        return eventDTO;
    }

    public UserDTO convertToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getUsername());
        userDTO.setPassword(user.getPassword());
        if (user.getRole() != null) {
            userDTO.setRoleId(user.getRole().getId());
        }
        return userDTO;
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