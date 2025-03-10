package net.weg.banco.controllers;

import net.weg.banco.models.dtos.ExceptionHandlerResponseDTO;
import net.weg.banco.models.exception.MesmoTitularException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionHandlerResponseDTO errorCapture(Exception e) {
        return new ExceptionHandlerResponseDTO(e.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionHandlerResponseDTO errorCapture(NoSuchElementException e) {
        return new ExceptionHandlerResponseDTO(e.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(MesmoTitularException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionHandlerResponseDTO errorCapture(MesmoTitularException e) {
        return new ExceptionHandlerResponseDTO(e.getMessage(), LocalDateTime.now());
    }
}
// restcontrolleradvice: try em cima de todas as controllers
// exceptionhandler: como se fosse o catch de todas as controllers