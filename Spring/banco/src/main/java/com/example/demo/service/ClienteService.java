package com.example.demo.service;

import com.example.demo.model.DTO.ClientePostRequestDTO;
import com.example.demo.model.DTO.ClientePutRequestDTO;
import com.example.demo.model.Entity.Cliente;
import com.example.demo.model.Entity.Conta;
import com.example.demo.model.exceptions.MesmoTitularException;
import com.example.demo.repository.ClienteRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ClienteService {

    private ClienteRepository repository;
    private ContaService contaService;



    public Cliente cadastrar(@Valid ClientePostRequestDTO clienteDto) {
        Cliente cliente = clienteDto.convert();
        return repository.save(cliente);
    }

    public Cliente editar(@NotNull @Positive Integer id, @Valid ClientePutRequestDTO clienteDTO) {
        if(repository.existsById(id)){
            System.out.println(clienteDTO.toString());
            Cliente cliente = clienteDTO.convert();
            cliente.setId(id);
            return repository.save(cliente);

        }
        throw new NoSuchElementException();

    }

    public Cliente buscarCliente(Integer id) {
        return repository.findById(id).get();
    }

    public Page<Cliente> buscarClientes(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Cliente remover(@NotNull @Positive Integer id) {
        Cliente cliente = repository.findById(id).get();
        repository.delete(cliente);
        return cliente;
    }

    public Cliente alterarConta(@NotNull @Positive Integer id, @NotNull @Positive Integer idConta) {
        Cliente cliente = repository.findById(id).get();
        Conta conta = contaService.buscarConta(idConta);
        if(cliente.getContas().contains(conta)){
            cliente.removerConta(conta);
        } else{

            if(conta.getTitular()==null){

                cliente.addConta(conta);

            }else{

                throw new MesmoTitularException();

            }

        }

        return repository.save(cliente);

    }
}
