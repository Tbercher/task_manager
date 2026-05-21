package com.trevorbercher.taskmanager.controller;

import com.trevorbercher.taskmanager.entity.Task;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {


    // Temporary in-memory task list
    private List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public List<Task> getAllTasks(){
        return tasks;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        task.setId(nextId++);
        task.setCreatedAt(LocalDateTime.now());
        task.setCompleted(false);
        tasks.add(task);

        return task;
    }

}
