package net.weg.banco.models.dtos;

public record ClienteContaResponseDTO(
        Integer id,
        String nome,
        Long cpf) {
}
