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

    //SELECT * FROM tasks WHERE author = :author_id ORDER BY status ASC
    @Query(
            value = "SELECT * FROM tasks WHERE author = :author_id ORDER BY CASE status " +
                    "WHEN 'OPEN' THEN 1 " +
                    "WHEN 'IN_PROGRESS' THEN 2 " +
                    "WHEN 'ON_HOLD' THEN 3 " +
                    "WHEN 'CLOSED' THEN 4 " +
                    "ELSE 5 " +
                    "END",
            nativeQuery = true)
    List<Task> getAllByAuthorIdStatusASC(@Param("author_id") int authorId);

    //SELECT * FROM tasks WHERE author = :author_id ORDER BY priority ASC
    @Query(
            value = "SELECT * FROM tasks WHERE author = :author_id ORDER BY CASE priority " +
                    "WHEN 'CRITICAL' THEN 1 " +
                    "WHEN 'HIGH' THEN 2 " +
                    "WHEN 'MEDIUM' THEN 3 " +
                    "WHEN 'LOW' THEN 4 " +
                    "ELSE 5 " +
                    "END",
            nativeQuery = true)
    List<Task> getAllByAuthorIdPriorityASC(@Param("author_id") int authorId);

    @Query(
            value = "SELECT * FROM tasks WHERE author = :author_id ORDER BY deadline ASC",
            nativeQuery = true)
    List<Task> getAllByAuthorIdDeadlineASC(@Param("author_id") int authorId);

}
