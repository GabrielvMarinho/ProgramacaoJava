package com.example.demo.model.DTO;

import com.example.demo.model.Entity.Conta;

import java.util.List;

public record ClientePutRequestDTO(
        String nome,
        Long cpf,
        List<Conta> contas
) {
}
