package net.weg.banco.models.dtos;

import lombok.Builder;

@Builder
public record ContaResponseDTO(
        Integer id,
        Integer numero,
        Double saldo,
        Double limite,
        ClienteContaResponseDTO titular) {
}
