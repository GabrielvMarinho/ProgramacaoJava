package com.example.demo.service;

import com.example.demo.model.DTO.ContaPostRequestDTO;
import com.example.demo.model.DTO.ContaPutRequestDTO;
import com.example.demo.model.Entity.Cliente;
import com.example.demo.model.Entity.Conta;
import com.example.demo.repository.ContaRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContaService {

    @Lazy
    private ClienteService clienteService;
    @NonNull
    private final ContaRepository repository;

    public Conta criarConta(ContaPostRequestDTO contaDto){
        Cliente cliente = clienteService.buscarCliente(contaDto.id_titular());
        Conta conta = contaDto.convert(cliente);
        return repository.save(conta);
    }

    public List<Conta> buscarContas(){
        List<Conta> contas = repository.findAll();
        System.out.println(contas);
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


    public Conta atualizarConta(Integer id, ContaPutRequestDTO contaDto) {

        Conta contaAntiga = buscarConta(id);
        Conta contaEditada = contaDto.convert();
        contaEditada.setId(id);
        contaEditada.setNumero(contaAntiga.getNumero());
        contaEditada.setSaldo(contaAntiga.getSaldo());

        return repository.save(contaEditada);
    }

    public Conta alterarLimite(Integer id, Double limite) {
        Conta conta = buscarConta(id);
        conta.setLimite(limite);
        return repository.save(conta);
    }


}
