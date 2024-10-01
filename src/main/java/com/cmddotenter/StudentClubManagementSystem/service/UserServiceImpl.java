package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.Converter.UserDtoConverter;
import com.cmddotenter.StudentClubManagementSystem.dto.request.UserEntityConverter;
import com.cmddotenter.StudentClubManagementSystem.dto.RoleDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.UserDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Role;
import com.cmddotenter.StudentClubManagementSystem.entity.User;
import com.cmddotenter.StudentClubManagementSystem.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {


    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserDtoConverter userDtoConverter;
    private final UserEntityConverter userEntityConverter;

    public UserServiceImpl(UserRepository userRepository,RoleService roleService, UserDtoConverter userDtoConverter,UserEntityConverter userEntityConverter) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.userDtoConverter = userDtoConverter;
        this.userEntityConverter = userEntityConverter;
    }

    @Override
    public List<UserDTO> findAll() {
        return userDtoConverter.convert(userRepository.findAll());
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<User> result = userRepository.findById(id);
        User theUser = result.orElseThrow(() -> new RuntimeException("Did not find event id - " + id));
        return userDtoConverter.convert(theUser);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        RoleDTO existingRole = roleService.findById(userDTO.getRoleId());
        User theUser = userEntityConverter.convert(userDTO);
        theUser.setRole(new Role(existingRole.getId(),existingRole.getName()));
        return userDtoConverter.convert(userRepository.save(theUser));
    }

    @Override
    public void DeleteById(Long id) {
        userRepository.deleteById(id);
    }




}
