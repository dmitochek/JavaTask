package com.example.demo.model;

import lombok.Data;

@Data
public class TaskDTO {
    Integer id;
    String name;
    String description;
    Integer status;
    Integer priority;
    UserDTO author;
}
