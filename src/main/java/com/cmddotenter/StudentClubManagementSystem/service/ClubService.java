package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.ClubDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateClubRequest;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateEventRequest;

import java.util.List;

public interface ClubService {
    List <ClubDTO> findAll();

    ClubDTO findById(long theId);

    void createClub(CreateClubRequest request);

    void deleteById(long theId);
}
