package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserDTO;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/apt/users")
public class UserController{
    @Autowired
    private ModelMapper modelMapper;
    private UserService userService;
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers().stream().map(user ->
                modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") int id) throws UserNotFoundException {
        User user = userService.getUserById(id);

        UserDTO response = modelMapper.map(user, UserDTO.class);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User postRequest = modelMapper.map(userDTO, User.class);
        User user = userService.createUser(postRequest);

        UserDTO postResponse = modelMapper.map(user, UserDTO.class);
        return new ResponseEntity<UserDTO>(postResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") int id) throws UserNotFoundException {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }


}
