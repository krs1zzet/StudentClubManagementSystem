package com.cmddotenter.StudentClubManagementSystem.dto.Converter;

import com.cmddotenter.StudentClubManagementSystem.dto.RoleDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleDtoConverter {
    public RoleDTO convert (Role from){
        return new RoleDTO(
                from.getId(),
                from.getName()
        );
    }

    public List<RoleDTO> convert (List<Role> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }

}
