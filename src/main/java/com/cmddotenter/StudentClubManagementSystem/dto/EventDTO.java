package com.cmddotenter.StudentClubManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDTO {
    private long id;
    private String name;
    private String date;
    private String description;
    private long clubId;


}