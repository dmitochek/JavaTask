package com.example.demo.exception;

public class TaskNotFoundException extends Exception{
    public TaskNotFoundException(Integer id) {
        super("Task with current id(" + id + ") not exist!");
    }
}
