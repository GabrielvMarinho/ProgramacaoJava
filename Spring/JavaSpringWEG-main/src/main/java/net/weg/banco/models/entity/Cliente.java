package net.weg.banco.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.banco.models.dtos.ClienteContaResponseDTO;
import net.weg.banco.models.dtos.ClienteResponseDTO;
import net.weg.banco.models.dtos.ContaClienteResponseDTO;

import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tb_cliente")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Long cpf;

//    @ManyToMany
//    @JoinTable(
//            name = "tb_contas_titulares",
//            joinColumns =
//                @JoinColumn(name = "cliente_id"),
//            inverseJoinColumns =
//                @JoinColumn(name = "conta_id")
//    )
    @OneToMany(mappedBy = "titular", cascade = CascadeType.MERGE)
//    private Set<Conta> contas = new HashSet<>();
    private List<Conta> contas;

    public List<Conta> getContas() {
        if (contas == null) {
            return new ArrayList<>();
//            return Collections.unmodifiableList(contas);
        } else {
            return contas;
        }
    }

    public void addConta(@NotNull Conta conta) {
        if (!contas.contains(conta)) {
            contas.add(conta);
            conta.setTitular(this);
        } else {
            throw new RuntimeException("Conta ja adicionada");
        }
    }

    public void rmConta(@NotNull Conta conta) {
        if (contas.contains(conta)) {
            contas.remove(conta);
            conta.setTitular(null);
        } else {
            throw new RuntimeException("Conta nao encontrada");
        }
    }

    public void rmConta(@NotNull Integer id) {
        contas.removeIf(conta -> conta.getId().equals(id));
    }

    public ClienteResponseDTO convertToClienteResponseDTO() {
//        Set<ContaClienteResponseDTO> contasDto = contas.stream().map(Conta::convertToContaClienteResponseDTO).collect(Collectors.toSet());
        List<ContaClienteResponseDTO> contasDTO = contas.stream().map(Conta::convertToContaClienteResponseDTO).toList();
//        for (Conta c : contas) {
//            ContaClienteResponseDTO contaDto = c.convertToContaClienteResponseDTO();
//            contasDTO.add(contaDto);
//        }
        return new ClienteResponseDTO(id, nome, cpf, contasDTO);
    }

    public ClienteContaResponseDTO convertToClienteContaResponseDTO() {
        return new ClienteContaResponseDTO(id, nome, cpf);
    }
}
