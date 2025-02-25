package com.example.demo.model.DTO;

import com.example.demo.model.Entity.Cliente;
import com.example.demo.model.Entity.Conta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

public record ContaPostRequestDTO(
        @NotNull
//        List<Cliente> titulares,
        Cliente titular,

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
