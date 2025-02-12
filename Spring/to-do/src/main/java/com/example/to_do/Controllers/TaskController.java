package com.example.to_do.Controllers;

import com.example.to_do.Models.Task;
import com.example.to_do.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("readTask")
    public List<Task> createTask(){
        return taskRepository.findAll();
    }
    @PostMapping("createTask")
    public String createTask(@RequestBody Task task){
        taskRepository.save(task);
        return "success";
    }
    @PutMapping("updateTask")
    public String updateTask(@RequestParam Long id, @RequestBody Task task){
        Task taskExistente = taskRepository.findById(id).orElseThrow();
        taskExistente.setDescricao(task.getDescricao());
        taskExistente.setPrioridade(task.getPrioridade());
        taskExistente.setStatus(task.getStatus());
        taskExistente.setTitulo(task.getTitulo());
        taskRepository.save(taskExistente);
        return "success";
    }
}
