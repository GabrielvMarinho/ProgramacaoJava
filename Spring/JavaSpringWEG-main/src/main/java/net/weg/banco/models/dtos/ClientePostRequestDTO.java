package net.weg.banco.models.dtos;

import net.weg.banco.models.entity.Cliente;
import net.weg.banco.models.entity.Conta;

import java.util.List;

public record ClientePostRequestDTO(
        String nome,
        Long cpf,
        List<Conta> contas
) {
    public Cliente convert() {
        return Cliente.builder()
                .cpf(cpf)
                .nome(nome)
                .contas(contas)
                .build();
    }
}
