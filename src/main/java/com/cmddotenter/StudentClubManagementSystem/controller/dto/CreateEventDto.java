package com.cmddotenter.StudentClubManagementSystem.controller.dto;


public class CreateEventDto {
    private String name;
    private String description;
    private String date;
    private long clubId;

    public CreateEventDto() {
    }

    public CreateEventDto(String name, String description,  String date, long clubId) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.clubId = clubId;
    }



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public String getDate() {
        return date;
    }


    public long getClubId() {
        return clubId;
    }
}
