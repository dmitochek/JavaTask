package com.example.demo.service.impl;

import com.example.demo.entity.Task;
import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    @Override
    public List<Task> getUserTasks(int id) throws UserNotFoundException {
        return null;
    }

    @Override
    public Task createTask(Task task) {
        return null;
    }

    @Override
    public void deleteTask(int id) throws TaskNotFoundException {

    }

    @Override
    public Task getTaskById(int id) throws TaskNotFoundException {
        return null;
    }

    @Override
    public Task updateTask(int id, Task task) throws TaskNotFoundException {
        return null;
    }
}
