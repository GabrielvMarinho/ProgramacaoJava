package com.example.demo.controller;

import com.example.demo.model.DTO.ClientePostRequestDTO;
import com.example.demo.model.DTO.ClientePutRequestDTO;
import com.example.demo.model.DTO.ClienteResponseDTO;
import com.example.demo.model.Entity.Cliente;
import com.example.demo.service.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
            @Valid @RequestBody ClientePutRequestDTO clienteDTO){
        return service.editar(id, clienteDTO);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente alterarContas(
            @PathVariable Integer id,
            @RequestParam Integer idConta){
        return service.alterarConta(id, idConta);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Cliente> buscarCliente(@PageableDefault(
            size=20,
            sort="nome",
            direction = Sort.Direction.ASC,
            page=0
    )Pageable pageable){
        return service.buscarClientes(pageable);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO buscarCliente(@PathVariable Integer id){
        Cliente cliente = service.buscarCliente(id);
        //return cliente.convert();
        return null;
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Cliente removerCliente(@PathVariable Integer id){
        return service.remover(id);
    }
}
