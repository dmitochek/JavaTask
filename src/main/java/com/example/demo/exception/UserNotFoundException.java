package com.example.demo.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(Integer id) {
        super("User with current id(" + id + ") not exist!");
    }
}