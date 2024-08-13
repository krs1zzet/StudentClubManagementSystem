package com.cmddotenter.StudentClubManagementSystem.dto.Converter;

import com.cmddotenter.StudentClubManagementSystem.dto.ClubDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClubDtoConverter {
    public ClubDTO convert(Club from) {
        return new ClubDTO (
                from.getId(),
                from.getName(),
                from.getDescription()
        );
    }

    public List<ClubDTO> convert(List<Club> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }

}
