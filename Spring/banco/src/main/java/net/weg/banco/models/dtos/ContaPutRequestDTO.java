package net.weg.banco.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import net.weg.banco.models.entity.Cliente;
import net.weg.banco.models.entity.Conta;

public record ContaPutRequestDTO(
        @NotNull
        Cliente titular,
        @PositiveOrZero
        @NotNull
        Double limite) {

    public Conta convert() {
        return Conta.builder()
                .titular(titular)
                .limite(limite)
                .build();
    }
}
