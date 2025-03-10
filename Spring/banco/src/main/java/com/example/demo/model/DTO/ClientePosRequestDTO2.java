package com.example.demo.model.DTO;

import com.example.demo.model.Entity.Cliente;
import com.example.demo.model.Entity.Conta;

import java.util.List;

public record ClientePosRequestDTO2 (
        String nome,
        Long cpf,
        List<Conta> contas
){
    public Cliente.ClienteBuilder convert(){
        return Cliente.builder().nome(this.nome).cpf(this.cpf).contas(this.contas);
    }
}
