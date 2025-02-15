package com.example.to_do.Services;

import com.example.to_do.DTOs.TaskDTO;
import com.example.to_do.Models.Task;
import com.example.to_do.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<TaskDTO> selectTask(){
        //service business logic
        List<Task> list;
        list = taskRepository.findAll();

        List<TaskDTO> dtoList = new ArrayList<>();



        for(int i=0; i<list.size(); i++){
            dtoList.add(new TaskDTO(list.get(i)));
        }
        return dtoList;
    }
    public TaskDTO createTask(Task task){
        //service business logic
        taskRepository.save(task);
        //turning model to dto
        TaskDTO dto = new TaskDTO(task);
        return dto;
    }
    public TaskDTO updateTask(Long id, Task task){
        //service business logic
        Task taskExistente = taskRepository.findById(id).orElseThrow();
        taskExistente.setDescricao(task.getDescricao());
        taskExistente.setPrioridade(task.getPrioridade());
        taskExistente.setStatus(task.getStatus());
        taskExistente.setTitulo(task.getTitulo());
        taskRepository.save(taskExistente);
        //turning model to dto
        TaskDTO dto = new TaskDTO(task);
        return dto;
    }
    public TaskDTO deleteTask(Long id){
        //service business logic
        Task task = taskRepository.findById(id).orElseThrow();
        TaskDTO dto = new TaskDTO(task);
        taskRepository.delete(task);
        return dto;
    }
}
