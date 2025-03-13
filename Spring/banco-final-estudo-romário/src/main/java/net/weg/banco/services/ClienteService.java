package net.weg.banco.services;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import net.weg.banco.models.dtos.ClientePostRequestDTO;
import net.weg.banco.models.dtos.ClientePutRequestDTO;
import net.weg.banco.models.dtos.ClienteRequestDTO;
import net.weg.banco.models.entity.Cliente;
import net.weg.banco.models.entity.Conta;
import net.weg.banco.models.exception.MesmoTitularException;
import net.weg.banco.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ContaService contaService;
    private final ModelMapper modelMapper;

    public Cliente cadastrar(@Valid ClienteRequestDTO clienteDto) {
        Cliente cliente = clienteDto.convert();
        cliente.setContas(new ArrayList<>());
        return clienteRepository.save(cliente);
    }

    public Cliente cadastrar(@Valid ClientePostRequestDTO clienteDto) {
        Cliente cliente = clienteDto.convert();
        return clienteRepository.save(cliente);
    }

    public Cliente editar(
            @NotNull @Positive Integer id,
            @Valid ClientePutRequestDTO clienteDto) {
        if (clienteRepository.existsById(id)) {
            Cliente clienteAtual = buscar(id);
            Cliente cliente = clienteDto.convert();
            modelMapper.map(cliente, clienteAtual);
            cliente.setId(id);
            return clienteRepository.save(clienteAtual);
        } else {
            throw new NoSuchElementException("Cliente não existe");
        }
    }

    public Cliente alterarConta(@NotNull @Positive Integer id,
                                @NotNull @Positive Integer idConta) {
        Cliente cliente = clienteRepository.findById(id).get();
        Conta conta = contaService.getConta(idConta);
        if (cliente.getContas().contains(conta)) {
            System.out.println("O titular possui esta conta, removendo-a...");
            cliente.rmConta(conta);
        } else {
            if(conta.getTitular() == null) {
                System.out.println("A conta informada não possui um titular, adicionando-o...");
                cliente.addConta(conta);
            } else {
                System.out.println("A conta já possui um titular diferente");
                throw new RuntimeException("A conta já possui um titular.");
            }
        }
//        contaService.
        return clienteRepository.save(cliente);
    }

    public Cliente buscar(Integer id) {
        if (clienteRepository.existsById(id)) {
            return clienteRepository.findById(id).get();
        } else {
            throw new NoSuchElementException();
        }
    }

    public Page<Cliente> buscar(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public void remover(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }
    }
    public Cliente buscarPorNome(String nome){
        return clienteRepository.findByNome(nome);
    }




}
