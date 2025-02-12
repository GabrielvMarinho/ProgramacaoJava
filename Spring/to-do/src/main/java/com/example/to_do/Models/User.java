package com.example.to_do.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class User {

    @Id
    @EqualsAndHashCode.Exclude
    int id;
    String nome;
    String email;
    String senha;


}
