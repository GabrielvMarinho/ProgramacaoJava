package com.example.demo.controller;

import com.example.demo.model.DTO.ContaPutRequestDTO;
import com.example.demo.model.DTO.ContaResponseDTO;
import com.example.demo.model.DTO.ContaPostRequestDTO;
import com.example.demo.model.Entity.Conta;
import com.example.demo.service.ContaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

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
    public List<ContaResponseDTO> buscarContas(){
        List<ContaResponseDTO> contasList = service.buscarContas();


        return contasList;
    }

    @GetMapping("/page")
    public Page<ContaResponseDTO> buscarTodasAsContasPaginado(@PageableDefault(size = 20,
            sort = "saldo", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Conta> contaPage =
                service.buscarContas(pageable);
        List<ContaResponseDTO> contaResponseDTOList =
                contaPage.getContent().stream().map(
                        Conta::convertToContaResponseDTO).toList();
        return new PageImpl<>(
                contaResponseDTOList,
                contaPage.getPageable(),
                contaPage.getTotalElements()
        );
    }




    @GetMapping("/{id}")
    public ContaResponseDTO buscarContaPorId(@PathVariable Integer id){
        Conta conta = service.buscarConta(id);

        return conta.convert();
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public ContaResponseDTO cadastrarConta(@RequestBody @Valid ContaPostRequestDTO contaDto, SessionStatus sessionStatus){
        Conta conta = service.criarConta(contaDto);
        return conta.convertToContaResponseDTO();
    }

    @DeleteMapping("/{id}")
    public void deletarConta(@PathVariable Integer id){
        service.deletarConta(id);
    };
    @PutMapping("/{id}")
    public ContaResponseDTO atualizarConta(@PathVariable Integer id,
                                           @RequestBody ContaPutRequestDTO contaDto){

        Conta conta = service.atualizarConta(id, contaDto);
        return conta.convertToContaResponseDTO();
    }

    @PatchMapping("/{id}")
    public ContaResponseDTO alteraLimite(
            @PathVariable Integer id,
            @RequestParam Double limite){
        return service.alterarLimite(id, limite).convertToContaResponseDTO();
    }

}
