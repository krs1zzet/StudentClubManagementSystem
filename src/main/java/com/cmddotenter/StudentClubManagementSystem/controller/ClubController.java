package com.cmddotenter.StudentClubManagementSystem.controller;


import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.service.ClubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public List<Club> getAllClubs() {
        return clubService.getAllClubs();
    }

    @PostMapping ("/clubs")
    public Club createClub(String clubName, String clubDescription) {
        return clubService.createClub(clubName, clubDescription);
    }


}
