package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/tutorials/{author_id}")
    public ResponseEntity<List<Task>> getTasksById(@PathVariable("author_id") int author_id) {
        List<Task> tasks = new ArrayList<Task>();
        try {
            tasks.addAll(taskRepository.getAllByAuthorId(author_id));
            if (tasks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tasks, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
