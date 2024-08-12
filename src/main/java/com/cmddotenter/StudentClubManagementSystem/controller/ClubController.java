package com.cmddotenter.StudentClubManagementSystem.controller;


import com.cmddotenter.StudentClubManagementSystem.dto.ClubDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.service.ClubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public List<ClubDTO> findAll(){
        return clubService.findAll();
    }

    @PostMapping("/clubs")
    public ClubDTO addClub(@RequestBody ClubDTO theClub){
        theClub.setId(0);
        return clubService.save(theClub);
    }

    @PutMapping("/clubs")
    public ClubDTO updateClub(@RequestBody ClubDTO theClub){
        return clubService.save(theClub);
    }

    @DeleteMapping("/clubs/{clubId}")
    public void deleteClub(@PathVariable long clubId){
        ClubDTO club = clubService.findById(clubId);
        if(club == null){
            throw new RuntimeException("Club id not found - " + clubId);
        }
        clubService.deleteById(clubId);
    }


}
