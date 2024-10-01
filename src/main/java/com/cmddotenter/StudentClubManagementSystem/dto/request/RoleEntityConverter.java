package com.cmddotenter.StudentClubManagementSystem.dto.request;

import com.cmddotenter.StudentClubManagementSystem.dto.RoleDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleEntityConverter {

    public Role convert (RoleDTO from){
        return new Role(
                from.getId(),
                from.getName()
        );
    }

    public List<Role>convert(List<RoleDTO> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }


}


