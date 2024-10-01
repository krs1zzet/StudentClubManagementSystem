package com.cmddotenter.StudentClubManagementSystem.api.Service;

import com.cmddotenter.StudentClubManagementSystem.dto.ClubDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.repo.ClubRepository;
import com.cmddotenter.StudentClubManagementSystem.service.ClubServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClubServiceTest {

    @Mock
    private ClubRepository clubRepository;

    @InjectMocks
    private ClubServiceImpl clubServiceimpl;

    @Test
    public void ClubService_CreateClub_Return_ClubDTO(){
        //arrange
        Club club = Club.builder()
                .name("Test Club")
                .description("Test Description")
                .build();
        ClubDTO clubDTO = ClubDTO.builder()
                .clubName("Test Club")
                .clubDescription("Test Description")
                .build();

        when(clubRepository.save(Mockito.any(Club.class))).thenReturn(club);

        ClubDTO savedClub = clubServiceimpl.save(clubDTO);


        Assertions.assertThat(savedClub).isNotNull();



    }

    @Test
    public void ClubService_FindAll_Return_ClubDtoList(){
        //arrange
        Club club = Club.builder()
                .name("Test Club")
                .description("Test Description")
                .build();
        ClubDTO clubDTO = ClubDTO.builder()
                .clubName("Test Club")
                .clubDescription("Test Description")
                .build();

        when(clubRepository.findAll()).thenReturn(List.of(club));

        List<ClubDTO> clubDTOList = clubServiceimpl.findAll();

        Assertions.assertThat(clubDTOList).isNotNull();
        Assertions.assertThat(clubDTOList.size()).isEqualTo(1);

    }

    @Test
    public void ClubService_FindById_Returns_ClubDTO(){
        Club club = Club.builder()
                .name("Test Club")
                .description("Test Description")
                .build();
        ClubDTO clubDTO = ClubDTO.builder()
                .clubName("Test Club")
                .clubDescription("Test Description")
                .build();

        when(clubRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(club));

        Assertions.assertThat(clubServiceimpl.findById(1)).isNotNull();
        Assertions.assertThat(clubServiceimpl.findById(1).getClubName()).isEqualTo("Test Club");

    }

    @Test
    public void ClubService_DeleteById_Returns_Void(){
        Club club = Club.builder()
                .name("Test Club")
                .description("Test Description")
                .build();


        assertAll(() -> clubServiceimpl.deleteById(1L));


    }
}
