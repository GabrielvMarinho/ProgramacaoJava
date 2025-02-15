package com.example.to_do.Controllers;

import com.example.to_do.DTOs.TaskDTO;
import com.example.to_do.Models.Task;
import com.example.to_do.Repositories.TaskRepository;
import com.example.to_do.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public ResponseEntity<List<TaskDTO>> selectTask(){
        return ResponseEntity.ok(taskService.selectTask());
    }
    @PostMapping("/task")
    public ResponseEntity<String> createTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.createTask(task).toString());
    }
    @PutMapping("/task")
    public ResponseEntity<String> updateTask(@RequestParam Long id, @RequestBody Task task){
        return ResponseEntity.ok(taskService.updateTask(id, task).toString());
    }
    @DeleteMapping("/task")
    public ResponseEntity<String> deleteTask(@RequestParam Long id){
        return ResponseEntity.ok(taskService.deleteTask(id).toString());
    }
}
