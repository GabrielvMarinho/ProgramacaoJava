package net.weg.banco.models.dtos;

public record ContaClienteResponseDTO(
        Integer id,
        Double saldo,
        Double limite,
        Integer numero) {
}
