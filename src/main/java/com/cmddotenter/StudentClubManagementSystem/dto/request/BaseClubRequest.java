package com.cmddotenter.StudentClubManagementSystem.dto.request;


import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BaseClubRequest {

    private String clubName;
    private String clubDescription;

    public String getName() {
        return clubName;
    }
    public String getDescription() {
        return clubDescription;
    }
}
