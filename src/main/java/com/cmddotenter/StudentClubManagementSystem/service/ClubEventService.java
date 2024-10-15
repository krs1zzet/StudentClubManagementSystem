package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.request.AssignClubEventRequest;

public interface ClubEventService {
    void assignClubToEvent(AssignClubEventRequest request);
}
