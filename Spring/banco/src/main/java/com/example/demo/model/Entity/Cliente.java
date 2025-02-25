package com.example.demo.model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @OneToOne(mappedBy = "titular")
    private Conta conta;
}
