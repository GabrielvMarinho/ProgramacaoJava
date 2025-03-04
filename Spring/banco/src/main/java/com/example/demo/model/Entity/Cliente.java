package com.example.demo.model.Entity;

import com.example.demo.model.DTO.ClienteContaGetResponseDTO;
import com.example.demo.model.DTO.ClienteResponseDTO;
import com.example.demo.model.DTO.ContaClienteResponseDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tb_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Long cpf;

    @OneToMany(mappedBy = "titular")
    private Set<Conta> contas = new HashSet<>();

    public Set<Conta> getContas(){
        if(contas !=null){
            return Collections.unmodifiableSet(contas);
        }
        return new HashSet<>();

    }
    public ClienteResponseDTO convertToClienteResponseDTO(){
        Set< ContaClienteResponseDTO> contasDto =
                this.contas.stream().map(Conta::convertToContaClienteResponseDTO).collect(Collectors.toSet());
        return new ClienteResponseDTO(this.id, this.nome, this.cpf, contasDto);
    }

    public void addConta(@NotNull Conta conta){
        this.contas.add(conta);
    }
    public void removerConta(@NotNull Conta conta){
        this.contas.remove(conta);
    }
    public ClienteContaGetResponseDTO convertToClienteContaResponseDTO(){
        return new ClienteContaGetResponseDTO(this.id, this.nome, this.cpf);
    }

//    @ManyToMany
//    @JoinTable(
//            name = "tb_cliente_conta",
//            joinColumns = //foreign key da entidade que vc esta
//            @JoinColumn(name= "cliente_id"),
//            inverseJoinColumns = //foreign key da entidade que vc não esta
//            @JoinColumn(name = "conta_id")
//                )
    //(mappedBy = "titular") ele não cria uma nova foreign key, mas na vdd diz que
    // essa foreign key deve ser da foreign key da outra Classe (conta nesse caso)
    // literalmente (bianca) para não criar duas foreign keys
//    private List<Conta> contas;
//    @OneToOne(mappedBy = "titular")
//    private Conta conta;
}
