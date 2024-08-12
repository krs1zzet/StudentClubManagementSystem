package com.cmddotenter.StudentClubManagementSystem.dto;

import lombok.Data;

@Data
public class UserDTO {
    private  long id;
    private  String name;
    private  String password;
    private  Long roleId;
}
