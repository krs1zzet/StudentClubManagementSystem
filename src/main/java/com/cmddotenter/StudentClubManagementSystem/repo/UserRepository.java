package com.cmddotenter.StudentClubManagementSystem.repo;

import com.cmddotenter.StudentClubManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
}
