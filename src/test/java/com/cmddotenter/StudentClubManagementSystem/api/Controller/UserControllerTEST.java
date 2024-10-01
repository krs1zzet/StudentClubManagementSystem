package com.cmddotenter.StudentClubManagementSystem.api.Controller;

import com.cmddotenter.StudentClubManagementSystem.controller.UserController;
import com.cmddotenter.StudentClubManagementSystem.dto.UserDTO;
import com.cmddotenter.StudentClubManagementSystem.service.UserService;
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

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void getUsers() throws Exception {
        List<UserDTO> users = Arrays.asList(new UserDTO(), new UserDTO());
        when(userService.findAll()).thenReturn(users);

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(users.size()));

        verify(userService, times(1)).findAll();
    }

    @Test
    void addUser() throws Exception {
        UserDTO user = new UserDTO();
        when(userService.save(any(UserDTO.class))).thenReturn(user);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(user.getId()));

        verify(userService, times(1)).save(any(UserDTO.class));
    }

    @Test
    void updateUser() throws Exception {
        UserDTO user = new UserDTO();
        when(userService.save(any(UserDTO.class))).thenReturn(user);

        mockMvc.perform(put("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(user.getId()));

        verify(userService, times(1)).save(any(UserDTO.class));
    }

    @Test
    void deleteUser() throws Exception {
        doNothing().when(userService).DeleteById(anyLong());

        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isOk());

        verify(userService, times(1)).DeleteById(anyLong());
    }
}