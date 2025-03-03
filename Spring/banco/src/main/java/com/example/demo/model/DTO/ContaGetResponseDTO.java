package com.example.demo.model.DTO;

import com.example.demo.model.Entity.Cliente;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.ToString;

public record ContaGetResponseDTO(
        Integer numero,

        Double saldo,

        Double limite,

        ClienteContaGetResponseDTO titular
) {
}
