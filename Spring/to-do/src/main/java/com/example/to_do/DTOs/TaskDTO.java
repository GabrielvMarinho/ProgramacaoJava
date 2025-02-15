package com.example.to_do.DTOs;

import com.example.to_do.Models.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class TaskDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String titulo;
    String descricao;
    String status;
    String prioridade;

    public TaskDTO(Task task){
        this.titulo = task.getTitulo();
        this.descricao = task.getDescricao();
        this.status = task.getStatus();
        this.prioridade = task.getPrioridade();
    }

    @Override
    public String toString() {
        return "Task{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                ", prioriedade='" + prioridade + '\'' +
                '}';
    }
}
