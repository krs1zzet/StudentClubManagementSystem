package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.entity.Events;

import java.util.List;

public interface EventService {
    Events create (String name, String date, String description);
    Events findByName(String name);
    void deleteEventById(Long id);
    List<Events> getAllEvents();
}
