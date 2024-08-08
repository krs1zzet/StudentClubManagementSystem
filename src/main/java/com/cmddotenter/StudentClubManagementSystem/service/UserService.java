package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.entity.User;

import java.util.List;

public interface UserService {
    User createUser(String username, String password, String roleName);
    User findUserByUsername(String username);
    List<User> getAllUsers();
    void deleteUserById(Long id);

}
