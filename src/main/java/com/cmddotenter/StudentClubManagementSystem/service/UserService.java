package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.UserDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateUserRequest;
import com.cmddotenter.StudentClubManagementSystem.entity.User;

import java.util.List;

public interface UserService {
     List<UserDTO> findAll();

     UserDTO findById(Long id);

     void save(CreateUserRequest request);

     void DeleteById(Long id);

}
