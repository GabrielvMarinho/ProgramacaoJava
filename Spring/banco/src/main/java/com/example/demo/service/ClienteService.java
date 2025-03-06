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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ClienteService {

    @NonNull
    private ClienteRepository repository;
    @Lazy
    private ContaService contaService;
    @NonNull
    private final ModelMapper modelMapper;


    public Cliente cadastrar(@Valid ClientePostRequestDTO clienteDto) {
        Cliente cliente = clienteDto.convert();
        return repository.save(cliente);
    }

    public Cliente editar(@NotNull @Positive Integer id, @Valid ClientePutRequestDTO clienteDTO) {
        if(repository.existsById(id)){
            Cliente clienteAtual = buscarCliente(id);
            Cliente clienteEditado = clienteDTO.convert();

            modelMapper.map(clienteEditado, clienteAtual);


            return repository.save(clienteAtual);

        }
        throw new NoSuchElementException();

    }

    public Cliente buscarCliente(Integer id) {
        return repository.findById(id).get();
    }

    public Page<Cliente> buscarClientes(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void remover(@NotNull @Positive Integer id) {
        Cliente cliente = repository.findById(id).get();
        repository.delete(cliente);
    }

    public Cliente alterarConta(@NotNull @Positive Integer id, @NotNull @Positive Integer idConta) {
        Cliente cliente = repository.findById(id).get();
//        Conta conta = contaService.buscarConta(idConta);
//        if(cliente.getContas().contains(conta)){
//            cliente.removerConta(conta);
//        } else{
//
//            if(conta.getTitular()==null){
//
//                cliente.addConta(conta);
//
//            }else{
//
//                throw new MesmoTitularException();
//
//            }
//
//        }

        return repository.save(cliente);

    }
}
