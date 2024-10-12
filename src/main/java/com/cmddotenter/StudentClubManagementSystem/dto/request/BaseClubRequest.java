package com.cmddotenter.StudentClubManagementSystem.dto.request;


import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BaseClubRequest {

    private String clubName;
    private String clubDescription;

}
