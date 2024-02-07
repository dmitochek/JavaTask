package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    void deleteUser(int id) throws UserNotFoundException;
    User getUserById(int id) throws UserNotFoundException;
}
