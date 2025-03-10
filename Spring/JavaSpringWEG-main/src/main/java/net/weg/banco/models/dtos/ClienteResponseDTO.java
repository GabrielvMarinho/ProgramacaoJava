package net.weg.banco.models.dtos;

import java.util.List;

public record ClienteResponseDTO(
        Integer id,
        String nome,
        Long cpf,
        List<ContaClienteResponseDTO> contas
) {
}
