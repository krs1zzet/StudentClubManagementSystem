package com.cmddotenter.StudentClubManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClubDTO {

    private long id;
    private String clubName;
    private String clubDescription;

}
