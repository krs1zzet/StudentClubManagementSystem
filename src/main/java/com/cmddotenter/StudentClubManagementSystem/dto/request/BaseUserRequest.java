package com.cmddotenter.StudentClubManagementSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseUserRequest {
    private String username;
    private String password;
    private String email;
}
