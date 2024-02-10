package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.exception.UserNotFoundException;

import java.util.List;

public interface TaskService {
    List<Task> getUserTasks(int id) throws UserNotFoundException;
    Task createTask(Task task);
    void deleteTask(int id) throws TaskNotFoundException;
    Task getTaskById(int id) throws TaskNotFoundException;
    Task updateTask(int id, Task task) throws TaskNotFoundException;
    List<Task> getAllByAuthorIdStatusASC(int id) throws UserNotFoundException;
    List<Task> getAllByAuthorIdPriorityASC(int id) throws UserNotFoundException;

    List<Task> getAllByAuthorIdDeadlineASC(int id) throws UserNotFoundException;
}
