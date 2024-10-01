package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.Converter.RoleDtoConverter;
import com.cmddotenter.StudentClubManagementSystem.dto.request.RoleEntityConverter;
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
    private final RoleEntityConverter roleEntityConverter;

    public RoleServiceImpl(RoleRepository theRoleRepository,RoleDtoConverter roleDtoConverter, RoleEntityConverter roleEntityConverter) {
        RoleRepository = theRoleRepository;
        this.roleDtoConverter = roleDtoConverter;
        this.roleEntityConverter = roleEntityConverter;

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
    public RoleDTO save(RoleDTO theRole) {
        return roleDtoConverter.convert(RoleRepository.save(roleEntityConverter.convert(theRole)));
    }

    @Transactional
    @Override
    public void deleteById(long theId) {
        RoleRepository.deleteById(theId);
    }

}
