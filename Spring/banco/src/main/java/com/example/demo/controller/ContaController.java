package com.example.demo.controller;

import com.example.demo.model.DTO.ContaPostRequestDTO;
import com.example.demo.model.Entity.Conta;
import com.example.demo.service.ContaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/conta")
@AllArgsConstructor

public class ContaController {

    private ContaService service;
//    @RequestMapping(
//            method = RequestMethod.GET,
//            value = "/ola")
    // o get mapping é apenas uma abstração maior do requestmapping
    @GetMapping
    public List<Conta> buscarContas(){

        return service.buscarContas();
    }
    @GetMapping("/page")
    public Page<Conta> buscarTodasAsContasPaginado(
            @PageableDefault(
                    size=10,
                    sort="saldo",
                    direction= Sort.Direction.DESC,
                    page=0
            ) Pageable pageable){
        return service.buscarContas(pageable);
    }

    @GetMapping("/{id}")
    public Conta buscarContaPorId(@PathVariable Integer id){
        return service.buscarConta(id);
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Conta cadastrarConta(@RequestBody @Valid ContaPostRequestDTO contaDto, SessionStatus sessionStatus){
        Conta conta = service.criarConta(contaDto);
        return conta;

    }

    @DeleteMapping("/{id}")
    public String deletarConta(@PathVariable Integer id){
        service.deletarConta(id);
        return "Deletado";
    };
    @PutMapping("/{id}")
    public Conta atualizarConta(@PathVariable Integer id, @RequestBody Conta conta){
        return service.atualizarConta(id, conta);
    }

    @PatchMapping("/{id}")
    public Conta alteraLimite(
            @PathVariable Integer id,
            @RequestParam Double limite){
        return service.alterarLimite(id, limite);
    }

}
