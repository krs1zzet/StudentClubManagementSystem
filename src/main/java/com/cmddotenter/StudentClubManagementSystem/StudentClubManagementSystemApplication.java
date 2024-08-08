package com.cmddotenter.StudentClubManagementSystem;

import com.cmddotenter.StudentClubManagementSystem.entity.Club;
import com.cmddotenter.StudentClubManagementSystem.entity.User;
import com.cmddotenter.StudentClubManagementSystem.repo.ClubRepository;
import com.cmddotenter.StudentClubManagementSystem.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentClubManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentClubManagementSystemApplication.class, args);
	}




}
