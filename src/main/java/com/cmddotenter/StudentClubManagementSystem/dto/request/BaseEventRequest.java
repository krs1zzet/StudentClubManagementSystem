package com.cmddotenter.StudentClubManagementSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEventRequest {
    private String name;
    private String date;
    private String description;
}
