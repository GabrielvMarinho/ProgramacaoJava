package com.example.demo.model.DTO;

import java.time.LocalDateTime;

public record ExceptionHandlerResponseDTO(
        String mensagem,
        LocalDateTime horario

) {

}
