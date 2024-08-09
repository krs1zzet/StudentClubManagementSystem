package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.controller.dto.CreateEventDto;
import com.cmddotenter.StudentClubManagementSystem.entity.Event;

import java.util.List;




public interface EventService {

    List<Event> findAll();

    Event findById(long theId);

    Event save(CreateEventDto theEvent);

    void deleteById(long theId);
}
