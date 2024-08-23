package com.cmddotenter.StudentClubManagementSystem.api.repository;

import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.repo.ClubRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ClubRepositoryTests {
    @Autowired
    private ClubRepository clubRepository;

    @Test
    public void ClubRepository_SaveAll_ReturnSavedClub(){
        //arrange
        Club club = Club.builder()
                .name("Test Club")
                .description("Test Description")
                .build();

        //act
        Club savedClub = clubRepository.save(club);
        //assert
        Assertions.assertThat(savedClub).isNotNull();
        Assertions.assertThat(savedClub.getId()).isGreaterThan(0);

    }

    @Test
    public void ClubRepository_FindById_ReturnClub(){
        //arrange
        Club club = Club.builder()
                .name("Test Club")
                .description("Test Description")
                .build();

        Club savedClub = clubRepository.save(club);
        //act
        Club foundClub = clubRepository.findById(savedClub.getId()).orElse(null);
        //assert
        Assertions.assertThat(foundClub).isNotNull();
        Assertions.assertThat(foundClub.getId()).isEqualTo(savedClub.getId());
    }

    @Test
    public void ClubRepository_DeleteClub_ReturnNull(){
        //arrange
        Club club = Club.builder()
                .name("Test Club")
                .description("Test Description")
                .build();

        Club savedClub = clubRepository.save(club);
        //act
        clubRepository.deleteById(savedClub.getId());
        Club foundClub = clubRepository.findById(savedClub.getId()).orElse(null);
        //assert
        Assertions.assertThat(foundClub).isNull();
    }
    @Test
    public void ClubRepository_FindAll_ReturnAllClubs(){
        //arrange
        Club club1 = Club.builder()
                .name("Test Club 1")
                .description("Test Description 1")
                .build();

        Club club2 = Club.builder()
                .name("Test Club 2")
                .description("Test Description 2")
                .build();

        clubRepository.save(club1);
        clubRepository.save(club2);
        //act
        List<Club> clubs = clubRepository.findAll();
        //assert
        Assertions.assertThat(clubs).isNotNull();
        Assertions.assertThat(clubs.size()).isEqualTo(2);
    }
}
