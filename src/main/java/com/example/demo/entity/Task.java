package com.example.demo.entity;
import com.example.demo.enums.Priority;
import com.example.demo.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name="tasks")
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String name;

    @Column
    String description;

    //@Enumerated(EnumType.STRING)
    @Column
    @Enumerated(EnumType.STRING)
    Status status;

    @Column
    @Enumerated(EnumType.STRING)
    Priority priority;

    @Column(name="author")
    int author;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate deadline;
}
