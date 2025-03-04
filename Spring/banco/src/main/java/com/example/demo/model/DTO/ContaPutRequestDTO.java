package com.example.demo.model.DTO;

import com.example.demo.model.Entity.Cliente;
import com.example.demo.model.Entity.Conta;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ContaPutRequestDTO(
    @NotNull
//        List<Cliente> titulares,
    Cliente titular,


    @PositiveOrZero
    Double limite
) {


        public Conta convert() {
            return Conta.builder()
                    .limite(limite)
                    .titular(titular)
                    .build();
        }
}
