package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.RoleDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Role;
import com.cmddotenter.StudentClubManagementSystem.repo.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository RoleRepository;

    public RoleServiceImpl(RoleRepository theRoleRepository) {
        RoleRepository = theRoleRepository;
    }


    @Override
    public List<RoleDTO> findAll() {
        return RoleRepository.findAll().stream().map(this::ConvertToDTO).collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(long theId) {
        Optional<Role> result = RoleRepository.findById(theId);
        Role theRole = result.orElseThrow(() -> new RuntimeException("Did not find role id - " + theId));
        return ConvertToDTO(theRole);
    }

    @Transactional
    @Override
    public RoleDTO save(RoleDTO theRole) {
        return ConvertToDTO(RoleRepository.save(ConvertToEntity(theRole)));
    }

    @Transactional
    @Override
    public void deleteById(long theId) {
        RoleRepository.deleteById(theId);
    }

    private RoleDTO ConvertToDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());
        return roleDTO;
    }

    private Role ConvertToEntity(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());
        return role;
    }
}
