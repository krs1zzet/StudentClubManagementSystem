package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.ClubDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.repo.ClubRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;

    @Autowired

    public ClubServiceImpl(ClubRepository theClubRepository){clubRepository =theClubRepository;}


    @Override
    public List<ClubDTO> findAll() {
       return clubRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ClubDTO findById(long theId) {
        Optional<Club> result = clubRepository.findById(theId);
        if(result.isEmpty()) {
            throw new RuntimeException("did not found club id - " + theId);//throw return gibi calisir
        }
        return convertToDTO(result.get());
    }

    @Transactional
    @Override
    public ClubDTO save(ClubDTO theClub) {
        return convertToDTO(clubRepository.save(convertToEntity(theClub)));
    }

    @Transactional
    @Override
    public void deleteById(long theId) {
        clubRepository.deleteById(theId);
    }

    private ClubDTO convertToDTO(Club club) {
        ClubDTO clubDTO = new ClubDTO();
        clubDTO.setId(club.getId());
        clubDTO.setClubName(club.getName());
        clubDTO.setClubDescription(club.getDescription());
        return clubDTO;
    }

    private Club convertToEntity(ClubDTO clubDTO) {
        Club club = new Club();
        club.setId(clubDTO.getId());
        club.setName(clubDTO.getClubName());
        club.setDescription(clubDTO.getClubDescription());
        return club;
    }


}
