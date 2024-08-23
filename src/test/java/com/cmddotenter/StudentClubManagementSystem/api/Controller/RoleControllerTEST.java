package com.cmddotenter.StudentClubManagementSystem.api.Controller;

import com.cmddotenter.StudentClubManagementSystem.controller.RoleController;
import com.cmddotenter.StudentClubManagementSystem.dto.RoleDTO;
import com.cmddotenter.StudentClubManagementSystem.service.RoleService;
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

class RoleControllerTest {

    @Mock
    private RoleService roleService;

    @InjectMocks
    private RoleController roleController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(roleController).build();
    }

    @Test
    void findAll() throws Exception {
        List<RoleDTO> roles = Arrays.asList(new RoleDTO(), new RoleDTO());
        when(roleService.findAll()).thenReturn(roles);

        mockMvc.perform(get("/api/roles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(roles.size()));

        verify(roleService, times(1)).findAll();
    }

    @Test
    void addRole() throws Exception {
        RoleDTO role = new RoleDTO();
        when(roleService.save(any(RoleDTO.class))).thenReturn(role);

        mockMvc.perform(post("/api/roles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(role.getId()));

        verify(roleService, times(1)).save(any(RoleDTO.class));
    }

    @Test
    void updateRole() throws Exception {
        RoleDTO role = new RoleDTO();
        when(roleService.save(any(RoleDTO.class))).thenReturn(role);

        mockMvc.perform(put("/api/roles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(role.getId()));

        verify(roleService, times(1)).save(any(RoleDTO.class));
    }

    @Test
    void deleteRole() throws Exception {
        doNothing().when(roleService).deleteById(anyLong());

        mockMvc.perform(delete("/api/roles/1"))
                .andExpect(status().isOk());

        verify(roleService, times(1)).deleteById(anyLong());
    }
}