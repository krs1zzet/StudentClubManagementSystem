package com.cmddotenter.StudentClubManagementSystem.dto.Converter;

import com.cmddotenter.StudentClubManagementSystem.dto.ClubDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClubEntityConverter {
    public Club convert(ClubDTO from) {
        return new Club(
                from.getId(),
                from.getClubName(),
                from.getClubDescription()
        );
    }
    public List<Club> convert(List<ClubDTO> from)
    {
        return from.stream().map(this::convert).collect(java.util.stream.Collectors.toList());
    }
}
