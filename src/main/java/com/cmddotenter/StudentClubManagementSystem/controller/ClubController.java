package com.cmddotenter.StudentClubManagementSystem.controller;


import com.cmddotenter.StudentClubManagementSystem.dto.ClubDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateClubRequest;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateEventRequest;
import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.service.ClubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClubController {

    private static final Logger log = LoggerFactory.getLogger(ClubController.class);
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public ResponseEntity<List<ClubDTO>> findAll(){
        List<ClubDTO> clubDTOList = clubService.findAll();
        log.info("Clubs found");
        return ResponseEntity.ok(clubDTOList);
    }

    @PostMapping("/clubs")
    public ResponseEntity<Void> addClub(@RequestBody CreateClubRequest request){
        clubService.createClub(request);
        log.info("Club added");
        return ResponseEntity.ok().build();
    }

    @PutMapping("/clubs")
    public ResponseEntity<Void> updateClub(@RequestBody CreateClubRequest request){
        clubService.createClub(request);
        log.info("Club updated");
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/clubs/{clubId}")
    public void deleteClub(@PathVariable long clubId){
//        ClubDTO club = clubService.findById(clubId);
//        if(club == null){
//            throw new RuntimeException("Club id not found - " + clubId);
//        }
        clubService.deleteById(clubId);
    }


}
