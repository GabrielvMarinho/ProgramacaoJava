package com.example.demo.model.DTO;

import com.example.demo.model.Entity.Conta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ContaPostRequestDTO(
        @NotBlank
        String titular,
        @Positive @NotNull
        Integer numero,
        @PositiveOrZero
        Double limite
) {


    public Conta convert() {
        return Conta.builder()
                .numero(numero)
                .limite(limite)
                .titular(titular)
                .build();
    }
}
