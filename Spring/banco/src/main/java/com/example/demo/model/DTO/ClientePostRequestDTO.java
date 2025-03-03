package com.example.demo.model.DTO;

import com.example.demo.model.Entity.Cliente;

public record ClientePostRequestDTO(
        String nome,
        Long cpf
) {
    public Cliente convert() {
        return Cliente.builder()
                .cpf(this.cpf)
                .nome(this.nome)
                .build();
    }
}
