package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.EventDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Event;

import java.util.List;

public interface EventService {
    List<EventDTO> findAll();
    EventDTO findById(long theId);
    EventDTO save(EventDTO theEvent);
    void deleteById(long theId);
    public Event addUserToEvent(Long eventId, Long userId);



    }