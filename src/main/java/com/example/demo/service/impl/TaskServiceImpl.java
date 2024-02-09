package com.example.demo.service.impl;

import com.example.demo.entity.Task;
import com.example.demo.entity.User;
import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    public TaskServiceImpl(TaskRepository taskRepository) {
        super();
        this.taskRepository = taskRepository;
    }
    @Override
    public List<Task> getUserTasks(int id) throws UserNotFoundException {
        return taskRepository.getAllByAuthorId(id);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(int id) throws TaskNotFoundException {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        taskRepository.delete(task);
    }

    @Override
    public Task getTaskById(int id) throws TaskNotFoundException {
        Optional<Task> result = taskRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        } else {
            throw new TaskNotFoundException(id);
        }
    }

    @Override
    public Task updateTask(int id, Task task) throws TaskNotFoundException {
        Task taskFound = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        taskFound.setAuthor(task.getAuthor());
        taskFound.setStatus(task.getStatus());
        taskFound.setDescription(task.getDescription());
        taskFound.setPriority(task.getPriority());
        taskFound.setName(task.getName());

        return taskRepository.save(taskFound);
    }
}
