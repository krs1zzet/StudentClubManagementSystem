package com.cmddotenter.StudentClubManagementSystem.dto;

import lombok.Data;

import java.util.List;

@Data
public class EventDTO {
    private long id;
    private String name;
    private String date;
    private String description;
    private long clubId;
    private  List<UserDTO> attendees;


}