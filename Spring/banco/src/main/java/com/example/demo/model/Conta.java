package com.example.demo.model;

import lombok.*;
@Data //Basically calls all the notations at class-level
@Getter
@Setter //generate all setters, if put in top of the attribute would only make the setter for that attribute
@RequiredArgsConstructor
public class Conta {
    @NonNull
    @EqualsAndHashCode.Exclude //if a object with the same attribute is instantiated, they will be considered the same
    private int numero;
    @NonNull
    private String titular;
    @ToString.Exclude //excludes this attribute of the toString
    private double saldo;
    private double limite;
}