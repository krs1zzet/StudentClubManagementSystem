package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.entity.Club;

import java.util.List;

public interface ClubService {
    Club createClub(String clubName, String clubDescription);
    Club findByName(String clubName);
    void deleteClubById(Long id);
    List<Club> getAllClubs();
}
