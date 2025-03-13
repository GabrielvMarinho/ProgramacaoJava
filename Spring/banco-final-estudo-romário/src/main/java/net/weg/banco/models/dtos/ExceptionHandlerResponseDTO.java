package net.weg.banco.models.dtos;

import java.time.LocalDateTime;

public record ExceptionHandlerResponseDTO(
        String message,
        LocalDateTime time
) {
}
