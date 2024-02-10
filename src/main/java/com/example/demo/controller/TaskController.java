package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.TaskDTO;
import com.example.demo.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private ModelMapper modelMapper;
    private TaskService taskService;

    public TaskController(TaskService taskService){
        super();
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        Task postRequest = modelMapper.map(taskDTO, Task.class);
        Task task = taskService.createTask(postRequest);

        TaskDTO postResponse = modelMapper.map(task, TaskDTO.class);
        return new ResponseEntity<TaskDTO>(postResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable(name = "id") int id) throws TaskNotFoundException {
        taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).body("Task deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable(name = "id") int id) throws TaskNotFoundException {
        Task task = taskService.getTaskById(id);

        TaskDTO response = modelMapper.map(task, TaskDTO.class);

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable int id, @RequestBody TaskDTO taskDTO) throws TaskNotFoundException {
        Task taskRequest = modelMapper.map(taskDTO, Task.class);
        Task task = taskService.updateTask(id, taskRequest);

        TaskDTO postResponse = modelMapper.map(task, TaskDTO.class);

        return ResponseEntity.ok().body(postResponse);
    }

    @PostMapping("/{id}")
    public List<TaskDTO> getUserTasks(@PathVariable(name = "id") int id) throws UserNotFoundException {
        List<Task> response = taskService.getUserTasks(id);
        return response.stream().map(task ->
                modelMapper.map(task, TaskDTO.class)).collect(Collectors.toList());
    }

    @PostMapping("/sort/status/{id}")
    public List<TaskDTO> getUserTasksStatusASC(@PathVariable(name = "id") int id) throws UserNotFoundException {
        List<Task> response = taskService.getAllByAuthorIdStatusASC(id);
        return response.stream().map(task ->
                modelMapper.map(task, TaskDTO.class)).collect(Collectors.toList());
    }

    @PostMapping("/sort/priority/{id}")
    public List<TaskDTO> getUserTasksPriorityASC(@PathVariable(name = "id") int id) throws UserNotFoundException {
        List<Task> response = taskService.getAllByAuthorIdPriorityASC(id);
        return response.stream().map(task ->
                modelMapper.map(task, TaskDTO.class)).collect(Collectors.toList());
    }


}
