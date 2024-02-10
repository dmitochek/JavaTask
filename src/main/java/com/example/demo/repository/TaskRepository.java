package com.example.demo.repository;

import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query(
            value = "SELECT * FROM tasks WHERE author = :author_id",
            nativeQuery = true)
    List<Task> getAllByAuthorId(@Param("author_id") int authorId);

    @Query(
            value = "SELECT * FROM tasks WHERE author = :author_id ORDER BY status ASC",
            nativeQuery = true)
    List<Task> getAllByAuthorIdStatusASC(@Param("author_id") int authorId);

    @Query(
            value = "SELECT * FROM tasks WHERE author = :author_id ORDER BY priority ASC",
            nativeQuery = true)
    List<Task> getAllByAuthorIdPriorityASC(@Param("author_id") int authorId);

}
