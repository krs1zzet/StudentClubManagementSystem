package com.cmddotenter.StudentClubManagementSystem.repo;

import com.cmddotenter.StudentClubManagementSystem.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Events, Long> {
    Events findByName(String eventName);

}
