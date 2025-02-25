package com.example.demo.controller;

import com.example.demo.model.DTO.CLientePostRequestDTO;
import com.example.demo.model.DTO.ClientePostRequestDTO;
import com.example.demo.model.Entity.Cliente;
import com.example.demo.service.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {
    private final ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrar(@Valid @RequestBody ClientePostRequestDTO clienteDto){
        return service.cadastrar(clienteDto);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente editar(@PathVariable Integer id,
            @Valid @RequestBody ClientePostRequestDTO clienteDTO){
        return service.editar(id, clienteDTO);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)

}
