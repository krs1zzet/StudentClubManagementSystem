package com.cmddotenter.StudentClubManagementSystem.dto.Converter;

import com.cmddotenter.StudentClubManagementSystem.dto.EventDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.UserDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {
    public UserDTO convert(User from) {
        return new UserDTO(
                from.getId(),
                from.getUsername(),
                from.getPassword()
        );
    }

    public List<UserDTO> convert(List<User> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
