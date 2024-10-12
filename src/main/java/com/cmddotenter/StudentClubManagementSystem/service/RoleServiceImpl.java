package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.Converter.RoleDtoConverter;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateRoleRequest;
import com.cmddotenter.StudentClubManagementSystem.dto.RoleDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Role;
import com.cmddotenter.StudentClubManagementSystem.repo.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository RoleRepository;
    private final RoleDtoConverter roleDtoConverter;

    public RoleServiceImpl(RoleRepository theRoleRepository,RoleDtoConverter roleDtoConverter) {
        RoleRepository = theRoleRepository;
        this.roleDtoConverter = roleDtoConverter;

    }


    @Override
    public List<RoleDTO> findAll() {
        return roleDtoConverter.convert(RoleRepository.findAll());
    }

    @Override
    public RoleDTO findById(long theId) {
        Optional<Role> result = RoleRepository.findById(theId);
        Role theRole = result.orElseThrow(() -> new RuntimeException("Did not find role id - " + theId));
        return roleDtoConverter.convert(theRole);
    }

    @Transactional
    @Override
    public void save(CreateRoleRequest request) {
        Role theRole = new Role();
        theRole.setName(request.getName());
        RoleRepository.save(theRole);
    }

    @Transactional
    @Override
    public void deleteById(long theId) {
        RoleRepository.deleteById(theId);
    }

}
