package net.weg.banco.models.dtos;

import net.weg.banco.models.entity.Cliente;

public record ClienteRequestDTO(
        String nome,
        Long cpf
) {
    public Cliente convert() {
        return Cliente.builder()
                .cpf(cpf)
                .nome(nome)
                .build();
    }
}
