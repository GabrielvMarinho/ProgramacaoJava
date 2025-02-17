package com.example.demo.controller;

import com.example.demo.model.Conta;
import com.example.demo.service.ContaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Conta> metodoGet(){
        return service.buscarContas();
    }
    @GetMapping("/{id}")
    public Conta buscarContaPorId(@PathVariable Integer id){
        return service.buscarConta(id);
    }

    @PostMapping("/criar")
    public String cadastrarConta(@RequestBody Conta conta){
        service.criarConta(conta);
        return conta.toString();
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

    @PatchMapping
    public Conta alteraLimite(
            @RequestParam Integer id,
            @RequestParam Double limite){
        return service.alterarLimite(id, limite);
    }

}
