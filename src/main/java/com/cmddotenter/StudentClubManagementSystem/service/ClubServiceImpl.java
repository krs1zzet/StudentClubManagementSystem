package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.ClubDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.Converter.ClubDtoConverter;
import com.cmddotenter.StudentClubManagementSystem.dto.request.ClubEntityConverter;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateClubRequest;
import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.repo.ClubRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;
    private ClubDtoConverter clubDtoConverter;
    private ClubEntityConverter clubEntityConverter;

    @Autowired

    public ClubServiceImpl(ClubRepository theClubRepository, ClubDtoConverter clubDtoConverter , ClubEntityConverter clubEntityConverter){
        this.clubEntityConverter= clubEntityConverter;
        clubRepository =theClubRepository;
        this.clubDtoConverter = clubDtoConverter;}


    @Override
    public List<ClubDTO> findAll() {
       return clubDtoConverter.convert(clubRepository.findAll());
    }

    @Override
    public ClubDTO findById(long theId) {
        Optional<Club> result = clubRepository.findById(theId);
        Club theClub = result.orElseThrow(() -> new RuntimeException("Did not find club id - " + theId));
        return clubDtoConverter.convert(theClub);
    }

    @Transactional
    @Override
    public void createClub(CreateClubRequest request) {
        Club theClub = new Club();
        theClub.setName(request.getClubName());
        theClub.setDescription(request.getClubDescription());
        clubRepository.save(theClub);

    }

    @Transactional
    @Override
    public void deleteById(long theId) {
        clubRepository.deleteById(theId);
    }






}
