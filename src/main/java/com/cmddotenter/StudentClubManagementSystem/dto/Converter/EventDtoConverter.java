package com.cmddotenter.StudentClubManagementSystem.dto.Converter;

import com.cmddotenter.StudentClubManagementSystem.dto.EventDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Event;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventDtoConverter {
    public EventDTO convert(Event from) {
        return new EventDTO(
                from.getId(),
                from.getName(),
                from.getDate(),
                from.getDescription()
        );
    }

    public List<EventDTO> convert(List<Event> from) {
        return from.stream().map(this::convert).toList();
    }
}
