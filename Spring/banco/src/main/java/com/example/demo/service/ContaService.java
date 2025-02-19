package com.example.demo.service;

import com.example.demo.model.DTO.ContaPostRequestDTO;
import com.example.demo.model.Entity.Conta;
import com.example.demo.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ContaService {

    private ContaRepository repository;

    public Conta criarConta(ContaPostRequestDTO contaDto){
        Conta conta = contaDto.convert();
        return repository.save(conta);
    }

    public List<Conta> buscarContas(){
        return repository.findAll();
    }

    public Conta buscarConta(Integer id){
        return repository.findById(id).get();
    }



    public Page<Conta> buscarContas(Pageable pageable){
        return repository.findAll(pageable);
    }
    public void deletarConta(Integer id) {
        repository.deleteById(id);

    }


    public Conta atualizarConta(Integer id, Conta conta) {
        conta.setId(id);
        return repository.save(conta);
    }

    public Conta alterarLimite(Integer id, Double limite) {
        Conta conta = buscarConta(id);
        conta.setLimite(limite);
        return repository.save(conta);
    }


}
