package com.cmddotenter.StudentClubManagementSystem.repo;

import com.cmddotenter.StudentClubManagementSystem.entity.ClubEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubEventRepository extends JpaRepository<ClubEvent,Long> {
}
