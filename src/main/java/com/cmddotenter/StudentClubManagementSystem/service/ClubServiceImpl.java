package com.cmddotenter.StudentClubManagementSystem.service;

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

    @Autowired

    public ClubServiceImpl(ClubRepository theClubRepository){clubRepository =theClubRepository;}


    @Override
    public List<Club> findAll() {
        return clubRepository.findAll();
    }

    @Override
    public Club findById(long theId) {
        Optional<Club> result = clubRepository.findById((long) theId);
        if(result.isEmpty()) {
            throw new RuntimeException("did not found club id - " + theId);//throw return gibi calisir
        }
        return result.get();
    }

    @Transactional
    @Override
    public Club save(Club theClub) {
       return clubRepository.save(theClub) ;
    }

    @Transactional
    @Override
    public void deleteById(long theId) {
        clubRepository.deleteById(theId);
    }


}
