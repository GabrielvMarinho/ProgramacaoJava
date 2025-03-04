package com.example.demo.model.DTO;

public record ContaResponseDTO(
        Integer id,

        Integer numero,

        Double saldo,

        Double limite,

        ClienteContaGetResponseDTO titular
) {

}
