package net.weg.banco.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import net.weg.banco.models.entity.Cliente;
import net.weg.banco.models.entity.Conta;

import java.util.List;

public record ContaRequestDTO(
        @NotNull
        Integer idTitular,
        @Positive
        @NotNull
        Integer numero,
        @PositiveOrZero
        @NotNull
        Double limite) {

    public Conta convert(Cliente cliente) {
        return Conta.builder()
                .numero(numero)
                .titular(cliente)
                .limite(limite)
                .build();
    }
}
