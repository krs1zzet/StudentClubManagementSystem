package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.EventDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateEventRequest;
import com.cmddotenter.StudentClubManagementSystem.entity.Event;

import java.util.List;

public interface EventService {
    List<EventDTO> findAll();
    EventDTO findById(long theId);
    void save(CreateEventRequest request);
    void deleteById(long theId);
//    EventDTO addUserToEvent(Long eventId, Long userId);


}