package net.weg.banco.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.weg.banco.models.dtos.ContaPutRequestDTO;
import net.weg.banco.models.dtos.ContaRequestDTO;
import net.weg.banco.models.entity.Cliente;
import net.weg.banco.models.entity.Conta;
import net.weg.banco.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContaService {

    @NonNull
    private final ContaRepository repository;
    @Autowired @Lazy
    private ClienteService clienteService;


    public Conta criarConta(ContaRequestDTO contaDto){
        Cliente cliente = clienteService.buscar(contaDto.idTitular());
        Conta conta = contaDto.convert(cliente);
        return repository.save(conta);
    }

    public Conta getConta(Integer id) {
        return repository.findById(id).get();
    }

    public List<Conta> getContas() {
        return repository.findAll();
    }

    public Page<Conta> buscarContas(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Conta atualizarConta(Integer id, ContaPutRequestDTO contaDto) {
        Conta contaAntiga = getConta(id);
        Conta conta = contaDto.convert();
        conta.setId(id);
        conta.setNumero(contaAntiga.getNumero());
        conta.setTitular(contaAntiga.getTitular());
        conta.setSaldo(contaAntiga.getSaldo());
        return repository.save(conta);
    }

    public void removerConta(Integer id) {
        repository.deleteById(id);
    }

    private Specification<Conta> filtroId(Integer id){
        return ((root,
                 query,
                 criteriaBuilder) -> {
            criteriaBuilder.equal(root.get("id"), id);
        });
    }


    public Conta alterarLimite(Integer id, Double limite) {
        Conta conta = getConta(id);
        conta.setLimite(limite);
        return repository.save(conta);
    }
    public List<Conta> buscarContasFiltros(
            String nomeTitular, Integer numero
    ) {
        return repository.findByTitular_NomeContainsAndNumeroOrderByNumero(nomeTitular, numero);
    }
}
