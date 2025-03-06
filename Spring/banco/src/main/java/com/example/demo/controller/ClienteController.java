package com.example.demo.controller;

import com.example.demo.model.DTO.ClientePostRequestDTO;
import com.example.demo.model.DTO.ClientePutRequestDTO;
import com.example.demo.model.DTO.ClienteResponseDTO;
import com.example.demo.model.Entity.Cliente;
import com.example.demo.service.ClienteService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {
    private final ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDTO cadastrar(@Valid @RequestBody ClientePostRequestDTO clienteDto){
        System.out.println(clienteDto);
        Cliente cliente = service.cadastrar(clienteDto);

        return cliente.convertToClienteResponseDTO();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO editar(@PathVariable Integer id,
            @Valid @RequestBody ClientePutRequestDTO clienteDTO){
        Cliente cliente = service.editar(id, clienteDTO);
        return cliente.convertToClienteResponseDTO();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO alterarContas(
            @PathVariable Integer id,
            @RequestParam Integer idConta){
        Cliente cliente = service.alterarConta(id, idConta);
        return cliente.convertToClienteResponseDTO();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ClienteResponseDTO> listar(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "nome",
                    direction = Sort.Direction.ASC
            ) Pageable pageable) {
        Page<Cliente> clientes = service.buscarClientes(pageable);
        return clientes.map(Cliente::convertToClienteResponseDTO);

    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO buscarCliente(@PathVariable Integer id){
        Cliente cliente = service.buscarCliente(id);
        return cliente.convertToClienteResponseDTO();
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable Integer id){
        service.remover(id);
    }
}
