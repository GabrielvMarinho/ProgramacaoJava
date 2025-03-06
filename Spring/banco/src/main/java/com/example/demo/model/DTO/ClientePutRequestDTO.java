package com.example.demo.model.DTO;

import com.example.demo.model.Entity.Cliente;
import com.example.demo.model.Entity.Conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public record ClientePutRequestDTO(
        String nome,
        Long cpf,
        List<Conta> contas
) {

    public Cliente convert() {
        return Cliente.builder()
                .nome(this.nome)
                .cpf(this.cpf)
                .contas(this.contas)
                .build();
    }
}
