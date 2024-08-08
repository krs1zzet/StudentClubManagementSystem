package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.repo.ClubRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;



    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Transactional
    @Override
    public Club createClub(String clubName, String clubDescription) {
        Club club = new Club(clubName, clubDescription);
        return clubRepository.save(club);
    }

    @Override
    public Club findByName(String clubName) {
        return clubRepository.findByName(clubName);
    }

    @Override
    public void deleteClubById(Long id) {
        clubRepository.deleteById(id);

    }

    @Override
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }




}
