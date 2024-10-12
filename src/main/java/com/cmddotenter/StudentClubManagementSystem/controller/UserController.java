package com.cmddotenter.StudentClubManagementSystem.controller;

import com.cmddotenter.StudentClubManagementSystem.dto.UserDTO;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateEventRequest;
import com.cmddotenter.StudentClubManagementSystem.dto.request.CreateUserRequest;
import com.cmddotenter.StudentClubManagementSystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> userDTOList = userService.findAll();
        log.info("Users found");
        return ResponseEntity.ok(userDTOList);

    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequest request){
        userService.save(request);
        log.info("User added");
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users")
    public ResponseEntity <Void> updateUser(@RequestBody CreateUserRequest request){
        userService.save(request);
        log.info("User updated");
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.DeleteById(userId);
    }
}
