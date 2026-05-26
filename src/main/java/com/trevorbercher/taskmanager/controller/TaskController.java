package com.trevorbercher.taskmanager.controller;

import com.trevorbercher.taskmanager.entity.Task;
import com.trevorbercher.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {


    private final TaskService taskService;

    //constructor injection
    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task savedTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask){
        return taskService.updateTask(id, updatedTask)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        return taskService.deleteTask(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();

    }

    @GetMapping("/completed/{status}")
    public List<Task> getTasksByCompletions(@PathVariable boolean status){
        return taskService.getTasksByCompletionStatus(status);
    }

    @GetMapping("/search")
    public List<Task> searchTasksByTitle(@RequestParam String title){
        return taskService.searchTasksByTitle(title);
    }

}
