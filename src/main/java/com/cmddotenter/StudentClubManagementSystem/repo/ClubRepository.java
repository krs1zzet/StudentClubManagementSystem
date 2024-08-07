package com.cmddotenter.StudentClubManagementSystem.repo;

import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {

}
