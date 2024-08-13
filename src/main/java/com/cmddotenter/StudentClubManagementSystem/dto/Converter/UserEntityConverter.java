package com.cmddotenter.StudentClubManagementSystem.dto.Converter;

import com.cmddotenter.StudentClubManagementSystem.dto.UserDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityConverter {
    public User convert (UserDTO from){
        return new User(
                from.getId(),
                from.getName(),
                from.getPassword(),
                null, //bu logic zaten save methodunda kullaniliyor
                    null
        );

    }
}
