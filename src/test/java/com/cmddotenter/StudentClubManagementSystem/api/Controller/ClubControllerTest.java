package com.cmddotenter.StudentClubManagementSystem.api.Controller;

import com.cmddotenter.StudentClubManagementSystem.controller.ClubController;
import com.cmddotenter.StudentClubManagementSystem.dto.ClubDTO;
import com.cmddotenter.StudentClubManagementSystem.service.ClubService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ClubControllerTest {

    @Mock
    private ClubService clubService;

    @InjectMocks
    private ClubController clubController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clubController).build();
    }

    @Test
    void findAll() throws Exception {
        List<ClubDTO> clubs = Arrays.asList(new ClubDTO(), new ClubDTO());
        when(clubService.findAll()).thenReturn(clubs);

        mockMvc.perform(get("/api/clubs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(clubs.size()));

        verify(clubService, times(1)).findAll();
    }

    @Test
    void addClub() throws Exception {
        ClubDTO club = new ClubDTO();
        when(clubService.save(any(ClubDTO.class))).thenReturn(club);

        mockMvc.perform(post("/api/clubs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(club.getId()));

        verify(clubService, times(1)).save(any(ClubDTO.class));
    }

    @Test
    void updateClub() throws Exception {
        ClubDTO club = new ClubDTO();
        when(clubService.save(any(ClubDTO.class))).thenReturn(club);

        mockMvc.perform(put("/api/clubs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(club.getId()));

        verify(clubService, times(1)).save(any(ClubDTO.class));
    }

    @Test
    void deleteClub() throws Exception {
        doNothing().when(clubService).deleteById(anyLong());

        mockMvc.perform(delete("/api/clubs/1"))
                .andExpect(status().isOk());

        verify(clubService, times(1)).deleteById(anyLong());
    }
}