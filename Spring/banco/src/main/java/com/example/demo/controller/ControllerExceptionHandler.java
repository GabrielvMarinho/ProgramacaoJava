package com.example.demo.controller;

import com.example.demo.model.DTO.ExceptionHandlerResponseDTO;
import com.example.demo.model.Entity.Conta;
import com.example.demo.model.exceptions.MesmoTitularException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionHandlerResponseDTO capturaDeErro(Exception exception){
        exception.printStackTrace();
        return new ExceptionHandlerResponseDTO(exception.getMessage(), LocalDateTime.now());
    }
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionHandlerResponseDTO capturaDeErro(NoSuchElementException exception){
        return new ExceptionHandlerResponseDTO(exception.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(MesmoTitularException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionHandlerResponseDTO capturaDeErro(MesmoTitularException exception){
        return new ExceptionHandlerResponseDTO(exception.getMessage(), LocalDateTime.now());
    }

}
