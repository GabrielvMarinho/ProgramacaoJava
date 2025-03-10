package com.example.demo.model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContaResponseDTO {
    Integer id;

    Integer numero;

    Double saldo;

    Double limite;

    ClienteContaGetResponseDTO titular;
}
