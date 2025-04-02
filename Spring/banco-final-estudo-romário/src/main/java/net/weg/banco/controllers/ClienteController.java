package net.weg.banco.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.banco.models.dtos.ClientePostRequestDTO;
import net.weg.banco.models.dtos.ClientePutRequestDTO;
import net.weg.banco.models.dtos.ClienteResponseDTO;
import net.weg.banco.models.entity.Cliente;
import net.weg.banco.services.ClienteService;
import net.weg.banco.models.dtos.ClienteRequestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private ClienteService service;
    private ModelMapper modelMapper;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDTO cadastrar(@RequestBody @Valid ClienteRequestDTO clienteDto) {
        Cliente cliente = service.cadastrar(clienteDto);
        return cliente.convertToClienteResponseDTO();
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDTO cadastrar(@RequestBody @Valid ClientePostRequestDTO clienteDto) {
        Cliente cliente = service.cadastrar(clienteDto);
        return cliente.convertToClienteResponseDTO();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO editar(@PathVariable Integer id,
                          @RequestBody @Valid ClientePutRequestDTO clienteDto) {
        Cliente cliente = service.editar(id, clienteDto);
        return cliente.convertToClienteResponseDTO();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO alterarContas(
            @PathVariable Integer id,
            @RequestParam Integer idConta) {
        Cliente cliente = service.alterarConta(id, idConta);
        return cliente.convertToClienteResponseDTO();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO buscarCliente (@PathVariable Integer id) {
        Cliente cliente = service.buscar(id);
        return cliente.convertToClienteResponseDTO();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ClienteResponseDTO> listar(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "nome",
                    direction = Sort.Direction.ASC
            ) Pageable pageable) {
        Page<Cliente> clientes = service.buscar(pageable);
        Page<ClienteResponseDTO> clientesDTO = clientes.map(cliente -> modelMapper.map(cliente, ClienteResponseDTO.class));
        System.out.println("-------------");
        System.out.println(clientesDTO);
        return clientesDTO;
//        List<ClienteResponseDTO> contentList = clientes.getContent().stream().map(
//                Cliente::convertToClienteResponseDTO).toList();
//        return new PageImpl<>(contentList,
//                clientes.getPageable(),
//                clientes.getTotalElements());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        service.remover(id);
    }


//    @GetMapping("/nome")
//    public ClienteResponseDTO buscarPorNome(@RequestParam String nome) {
//        return service.buscarPorNome(nome).convertToClienteResponseDTO();
//    }

}
