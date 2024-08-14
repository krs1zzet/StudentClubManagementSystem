package com.cmddotenter.StudentClubManagementSystem.dto.Converter;

import com.cmddotenter.StudentClubManagementSystem.dto.EventDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Event;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class EventEntityConverter {
    public Event convert (EventDTO from){
        return new Event(
        from.getId(),
        from.getName(),
        from.getDate(),
        from.getDescription(),
                null
        );
    }

    public List<Event> convert (List<EventDTO> from){
        return from.stream().map(this :: convert).collect(Collectors.toList());
    }
}
