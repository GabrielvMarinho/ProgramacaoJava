package com.example.demo.model.DTO;

public record ContaClienteResponseDTO(
    Integer id,
    Double saldo,
    Double limite,
    Integer numero
    ){
}
