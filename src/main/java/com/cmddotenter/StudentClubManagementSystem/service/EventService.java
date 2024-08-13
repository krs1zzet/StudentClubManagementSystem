package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.EventDTO;

import java.util.List;

public interface EventService {
    List<EventDTO> findAll();
    EventDTO findById(long theId);
    EventDTO save(EventDTO theEvent);
    void deleteById(long theId);
    public EventDTO addUserToEvent(Long eventId, Long userId);
    public void deleteUserFromEvent(Long eventId, Long userId);



    }