package com.cmddotenter.StudentClubManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClubDTO {

    private long id;
    private String clubName;
    private String clubDescription;

}
