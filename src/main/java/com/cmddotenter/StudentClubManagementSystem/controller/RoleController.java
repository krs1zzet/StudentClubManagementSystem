package com.cmddotenter.StudentClubManagementSystem.controller;

import com.cmddotenter.StudentClubManagementSystem.dto.RoleDTO;
import com.cmddotenter.StudentClubManagementSystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService theRoleService) {
        roleService = theRoleService;
    }

    @GetMapping("/roles")
    public List<RoleDTO> findAll() {
        return roleService.findAll();
    }

    @PostMapping("/roles")
    public RoleDTO addRole(@RequestBody RoleDTO role) {
        return roleService.save(role);
    }

    @PutMapping("/roles")
    public RoleDTO updateRole(@RequestBody RoleDTO role) {
        return roleService.save(role);
    }

    @DeleteMapping("/roles/{roleId}")
    public void deleteRole(@PathVariable long roleId) {
        roleService.deleteById(roleId);
    }
}
