package com.example.to_do.Controllers;

import com.example.to_do.DTOs.TaskDTO;
import com.example.to_do.Models.Task;
import com.example.to_do.Services.TaskService;
import io.swagger.annotations.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;
    /**
     * Retorna todas as tasks cadastradas
     * @return Lista de dtos representando todas as tarefas cadastradas
     */
    @GetMapping("/task")
    @Operation(summary="RETORNAR LISTA DE TASKS")
    @ApiResponse(responseCode = "200", description = "LISTA DE TASKS")
    public ResponseEntity<List<TaskDTO>> selectTask(){
        return ResponseEntity.ok(taskService.selectTask());
    }


    /**
     * Cria nova task no sistema
     * @param task Objeto Task contendo os dados da nova task
     * @return String confirmando a criação da task
     */
    @PostMapping("/task")
    @Operation(summary="CADASTRAR UMA TASK ESPECÍFICA")
    @ApiResponse(responseCode = "200", description = "UPDATE DE UMA TASK")
    public ResponseEntity<String> createTask(  @RequestBody Task task){
        return ResponseEntity.ok(taskService.createTask(task).toString());
    }


    /**
     * Atualiza task existente com base no ID fornecido
     * @param id   ID da task a ser atualizada
     * @param task Objeto Task contendo os novos dados
     * @return String confirmando a atualização da task
     */
    @Deprecated
    @Operation(summary = "POST ANTIGO", description = "MÉTODO DEPRECIADO")
    @PutMapping("/task")
    public ResponseEntity<String> updateTask(@RequestParam Long id, @RequestBody Task task){
        return ResponseEntity.ok(taskService.updateTask(id, task).toString());
    }
    /**
     * Deleta task específica do sistema pelo ID
     * @param id ID da task a ser deletada
     * @return String confirmando a exclusão da task
     */
    @Operation(summary="DELETAR UMA TASK ESPECÍFICA")
    @DeleteMapping("/task")
    public ResponseEntity<String> deleteTask(@RequestParam Long id){
        return ResponseEntity.ok(taskService.deleteTask(id).toString());
    }
}
