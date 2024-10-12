package com.cmddotenter.StudentClubManagementSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserToEventRequest {
    private Long eventId;
    private Long userId;
    }

