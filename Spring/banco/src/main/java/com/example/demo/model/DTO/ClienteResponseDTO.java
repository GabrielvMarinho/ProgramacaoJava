package com.example.demo.model.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public record ClienteResponseDTO (
        Integer id,
        String nome,
        Long cpf,
        List<ContaClienteResponseDTO> contas
) {
}
