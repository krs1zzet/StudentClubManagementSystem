package com.cmddotenter.StudentClubManagementSystem.dto.Converter;

import com.cmddotenter.StudentClubManagementSystem.dto.EventDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.UserDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Event;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventDtoConverter {


    public EventDTO convert(Event from) {
        return new EventDTO(
                from.getId(),
                from.getName(),
                from.getDate(),
                from.getDescription(),
                from.getClub().getId(),
                from.getAttendees().stream().map(user -> new UserDTO(
                        user.getId(),
                        user.getUsername(),
                        user.getPassword(),
                        user.getRole().getId(),
                        null // Avoid circular reference
                )).collect(Collectors.toList())
        );
    }

    public List<EventDTO> convert(List<Event> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}




