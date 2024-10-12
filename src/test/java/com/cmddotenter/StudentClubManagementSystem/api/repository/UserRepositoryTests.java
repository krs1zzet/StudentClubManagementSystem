package com.cmddotenter.StudentClubManagementSystem.api.repository;


import com.cmddotenter.StudentClubManagementSystem.entity.User;
import com.cmddotenter.StudentClubManagementSystem.repo.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void UserRepository_SaveAll_ReturnSavedUser() {
        //Arrange

        User user = User.builder()
                .username("Test User")
                .password("Test Password")
                .build();

        //Act
        userRepository.save(user);
        User savedUser = userRepository.findById(user.getId()).orElse(null);

        //Assert

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void UserRepository_FindById_ReturnUser() {
        //Arrange

        User user = User.builder()
                .username("Test User")
                .password("Test Password")
                .build();

        User savedUser = userRepository.save(user);

        //Act
        User foundUser = userRepository.findById(savedUser.getId()).orElse(null);

        //Assert

        Assertions.assertThat(foundUser).isNotNull();
        Assertions.assertThat(foundUser.getId()).isEqualTo(savedUser.getId());
    }

    @Test
    public void UserRepository_DeleteUser_ReturnNull() {
        //Arrange

        User user = User.builder()
                .username("Test User")
                .password("Test Password")
                .build();

        User savedUser = userRepository.save(user);

        //Act
        userRepository.deleteById(savedUser.getId());
        User foundUser = userRepository.findById(savedUser.getId()).orElse(null);

        //Assert

        Assertions.assertThat(foundUser).isNull();
    }

    @Test
    public void UserRepository_FindAll_ReturnAllUsers() {
        //Arrange

        User user1 = User.builder()
                .username("Test User 1")
                .password("Test Password 1")
                .build();

        User user2 = User.builder()
                .username("Test User 2")
                .password("Test Password 2")
                .build();

        userRepository.save(user1);
        userRepository.save(user2);

        List<User> users = userRepository.findAll();


        Assertions.assertThat(users).isNotNull();
        Assertions.assertThat(users).hasSizeGreaterThan(1);
    }
}
