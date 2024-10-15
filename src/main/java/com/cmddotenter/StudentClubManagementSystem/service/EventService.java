package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.EventDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateEventRequest;

import java.util.List;

public interface EventService {
    List<EventDTO> findAll();
    EventDTO findById(long theId);
    void save(CreateEventRequest request);
    void deleteById(long theId);

}