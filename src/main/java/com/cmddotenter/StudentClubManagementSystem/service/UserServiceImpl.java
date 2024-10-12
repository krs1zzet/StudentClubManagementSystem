package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.dto.Converter.UserDtoConverter;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateUserRequest;
import com.cmddotenter.StudentClubManagementSystem.dto.UserDTO;
import com.cmddotenter.StudentClubManagementSystem.entity.User;
import com.cmddotenter.StudentClubManagementSystem.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {


    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserServiceImpl(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
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
    public void save(CreateUserRequest request) {
        User theUser = new User();
        theUser.setUsername(request.getUsername());
        theUser.setPassword(request.getPassword());
        userRepository.save(theUser);
    }

    @Override
    public void DeleteById(Long id) {
        userRepository.deleteById(id);
    }




}
