package com.example.demo.model.Entity;

import jakarta.persistence.*;
import lombok.*;
@Data //Basically calls all the notations at class-level
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @EqualsAndHashCode.Exclude //if a object with the same attribute is instantiated, they will be considered the same
    @Column(name = "numero_da_conta",
            nullable = false,
            unique = true)
    private Integer numero;

    @Column(nullable = false)
    private String titular;

    @ToString.Exclude //excludes this attribute of the toString
    private Double saldo;

    private Double limite;






}