package net.weg.banco.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.banco.models.dtos.ContaPutRequestDTO;
import net.weg.banco.models.dtos.ContaResponseDTO;
import net.weg.banco.models.dtos.ContaRequestDTO;
import net.weg.banco.models.entity.Conta;
import net.weg.banco.services.ContaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/conta")
@AllArgsConstructor
public class ContaController {

    private final ContaService service;

    //    @RequestMapping(
    //            method = RequestMethod.GET,
    //            value = "/hi")
    @GetMapping("/{id}")
    public ContaResponseDTO getConta(@PathVariable Integer id) {
        Conta conta = service.getConta(id);
        return conta.convertToContaResponseDTO();
    }

    @GetMapping
    public List<ContaResponseDTO> getContas() {
        List<Conta> contas = service.getContas();
        return contas.stream().map(Conta::convertToContaResponseDTO).toList();
    }

    @GetMapping("/pages")
    public Page<ContaResponseDTO> buscarTodasAsContasPaginado(
            @PageableDefault(
                    size = 5, // quantos elementos retorna
                    sort = "saldo", // atributo do objeto
                    direction = Sort.Direction.DESC, // organiza em ordem decrescente
                    page = 0 // pagina de retorno
            ) Pageable pageable) {
        Page<Conta> conta = service.buscarContas(pageable);
//        return conta.map(Conta::convertToContaResponseDTO);
        List<ContaResponseDTO> responseList = conta.getContent().stream()
                .map(Conta::convertToContaResponseDTO).collect(Collectors.toList());
        return new PageImpl<>(responseList, pageable, conta.getTotalElements());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaResponseDTO cadastrarConta(@RequestBody @Valid ContaRequestDTO contaDto) {
        Conta conta = service.criarConta(contaDto);
        return conta.convertToContaResponseDTO();
    }

    @DeleteMapping("/{id}")
    public void deletarConta(@PathVariable Integer id) {
        service.removerConta(id);
    }

    @PutMapping("/{id}")
    public ContaResponseDTO atualizarConta(@PathVariable Integer id, @RequestBody ContaPutRequestDTO contaDto) {
        return service.atualizarConta(id, contaDto).convertToContaResponseDTO();
    }

    @PatchMapping("/{id}")
    public ContaResponseDTO alterarLimite(@PathVariable Integer id, @RequestParam Double limite) {
        Conta conta = service.alterarLimite(id, limite);
        return conta.convertToContaResponseDTO();
    }
}

