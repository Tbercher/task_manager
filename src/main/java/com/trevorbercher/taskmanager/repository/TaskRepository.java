package com.trevorbercher.taskmanager.repository;

import com.trevorbercher.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Method name query
    // Translated SELECT * FROM tasks WHERE completed = :completed
    List<Task> findByCompleted(boolean completed);

    List<Task> findByTitleContainingIgnoreCase(String title);

    @Query("SELECT t FROM Task t Where t.completed = :completed")
    List<Task> findTasksByCompletionStatus(@Param("completed") boolean completed);

}
