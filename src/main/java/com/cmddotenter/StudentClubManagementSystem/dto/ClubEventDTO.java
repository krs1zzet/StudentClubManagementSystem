package com.cmddotenter.StudentClubManagementSystem.dto;

import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ClubEventDTO {
    private long id;
    private Club club;
    private Event event;
}
