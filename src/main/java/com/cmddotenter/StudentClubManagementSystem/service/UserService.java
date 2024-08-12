package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.UserDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.User;

import java.util.List;

public interface UserService {
    public List<UserDTO> findAll();

    public UserDTO findById(Long id);

    public UserDTO save(UserDTO user);

    public void DeleteById(Long id);

}
