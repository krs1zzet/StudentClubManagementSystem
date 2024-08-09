package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.entity.Club;

import java.util.List;

public interface ClubService {
    List <Club> findAll();

    Club findById(long theId);

    Club save(Club theClub);

    void deleteById(long theId);
}
