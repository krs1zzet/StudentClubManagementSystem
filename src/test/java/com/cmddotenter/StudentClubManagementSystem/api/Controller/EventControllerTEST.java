package com.cmddotenter.StudentClubManagementSystem.api.Controller;

import com.cmddotenter.StudentClubManagementSystem.controller.EventController;
import com.cmddotenter.StudentClubManagementSystem.dto.EventDTO;
import com.cmddotenter.StudentClubManagementSystem.service.EventService;
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

class EventControllerTest {

    @Mock
    private EventService eventService;

    @InjectMocks
    private EventController eventController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();
    }

    @Test
    void findAll() throws Exception {
        List<EventDTO> events = Arrays.asList(new EventDTO(), new EventDTO());
        when(eventService.findAll()).thenReturn(events);

        mockMvc.perform(get("/api/events"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(events.size()));

        verify(eventService, times(1)).findAll();
    }

    @Test
    void addEvent() throws Exception {
        EventDTO event = new EventDTO();
        when(eventService.save(any(EventDTO.class))).thenReturn(event);

        mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(event.getId()));

        verify(eventService, times(1)).save(any(EventDTO.class));
    }

    @Test
    void updateEvent() throws Exception {
        EventDTO event = new EventDTO();
        when(eventService.save(any(EventDTO.class))).thenReturn(event);

        mockMvc.perform(put("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(event.getId()));

        verify(eventService, times(1)).save(any(EventDTO.class));
    }

    @Test
    void deleteEvent() throws Exception {
        doNothing().when(eventService).deleteById(anyLong());

        mockMvc.perform(delete("/api/events/1"))
                .andExpect(status().isOk());

        verify(eventService, times(1)).deleteById(anyLong());
    }
}

