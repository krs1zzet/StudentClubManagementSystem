package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.ClubDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Club;

import java.util.List;

public interface ClubService {
    List <ClubDTO> findAll();

    ClubDTO findById(long theId);

    ClubDTO save(ClubDTO theClub);

    void deleteById(long theId);
}
