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
                //bunlarin sirasini yanlis yere yazarsan veri ciktisi yanlis gosteriyor
                from.getId(),
                from.getUsername(),
                from.getPassword(),
                from.getRole().getId(),
                from.getEvents().stream().map(event -> new EventDTO(
                        event.getId(),
                        event.getName(),
                        event.getDate(),
                        event.getDescription(),
                        event.getClub().getId(),
                        null
                )).collect(Collectors.toList())
        );
    }

    public List<UserDTO> convert (List<User> from ){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }

}
