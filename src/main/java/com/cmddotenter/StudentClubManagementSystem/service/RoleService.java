package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.RoleDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateRoleRequest;
import com.cmddotenter.StudentClubManagementSystem.entity.Role;

import java.util.List;

public interface RoleService {
    List<RoleDTO> findAll();

    RoleDTO findById(long theId);

    void save(CreateRoleRequest request);

    void deleteById(long theId);

}
