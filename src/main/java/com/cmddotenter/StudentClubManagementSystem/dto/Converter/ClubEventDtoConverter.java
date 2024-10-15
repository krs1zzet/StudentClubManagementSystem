package com.cmddotenter.StudentClubManagementSystem.dto.Converter;

import com.cmddotenter.StudentClubManagementSystem.dto.ClubEventDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClubEventDtoConverter {
    public ClubEventDTO convert(ClubEventDTO from) {
        return new ClubEventDTO(
                from.getId(),
                from.getClub(),
                from.getEvent()
        );
    }

    public List<ClubEventDTO> convert(List<ClubEventDTO> from) {
        return from.stream().map(this::convert).toList();
    }
}


