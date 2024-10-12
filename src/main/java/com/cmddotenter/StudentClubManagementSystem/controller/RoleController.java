package com.cmddotenter.StudentClubManagementSystem.controller;

import com.cmddotenter.StudentClubManagementSystem.dto.RoleDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateRoleRequest;
import com.cmddotenter.StudentClubManagementSystem.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);
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
    public ResponseEntity<Void> createRole(@RequestBody CreateRoleRequest request) {
        roleService.save(request);
        log.info("Role added");
        return ResponseEntity.ok().build();

    }

    @PutMapping("/roles")
    public ResponseEntity<Void> updateRole(@RequestBody CreateRoleRequest request) {
      roleService.save(request);
      log.info("Role updated");
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/roles/{roleId}")
    public void deleteRole(@PathVariable long roleId) {
        roleService.deleteById(roleId);
    }
}
