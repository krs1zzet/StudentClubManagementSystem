package com.cmddotenter.StudentClubManagementSystem.service;

import com.cmddotenter.StudentClubManagementSystem.entity.Role;
import com.cmddotenter.StudentClubManagementSystem.entity.User;
import com.cmddotenter.StudentClubManagementSystem.repo.RoleRepository;
import com.cmddotenter.StudentClubManagementSystem.repo.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public User createUser(String username, String password, String roleName) {
        Role role = roleRepository.findByName(roleName);
        if(role == null){
            role = new Role();
            role.setName(roleName);
            roleRepository.save(role);
        }
        User user = new User(username, password, role);
        return userRepository.save(user);
    }



    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


}
