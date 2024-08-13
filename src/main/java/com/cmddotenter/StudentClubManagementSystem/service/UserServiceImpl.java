package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.RoleDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.UserDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.Event;
import com.cmddotenter.StudentClubManagementSystem.entity.Role;
import com.cmddotenter.StudentClubManagementSystem.entity.User;
import com.cmddotenter.StudentClubManagementSystem.repo.RoleRepository;
import com.cmddotenter.StudentClubManagementSystem.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService {


    private final UserRepository userRepository;
    private final RoleService roleService;
    public UserServiceImpl(UserRepository userRepository,RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<User> result = userRepository.findById(id);
        User theUser = result.orElseThrow(() -> new RuntimeException("Did not find event id - " + id));
        return convertToDTO(theUser);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        RoleDTO existingRole = roleService.findById(userDTO.getRoleId());
        User theUser = convertToEntity(userDTO);
        theUser.setRole(new Role(existingRole.getId(),existingRole.getName()));
        return convertToDTO(userRepository.save(theUser));
    }

    @Override
    public void DeleteById(Long id) {
        userRepository.deleteById(id);
    }

     public UserDTO convertToDTO(User user){
        UserDTO userDTO = new UserDTO();
         userDTO.setId(user.getId());
         userDTO.setName(user.getUsername());
         if (user.getRole() != null) {
             userDTO.setRoleId(user.getRole().getId());
         }
         return userDTO;
    }

    public User convertToEntity(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getName());
        return user;
    }
}
