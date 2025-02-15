package com.example.to_do.DTOs;

import com.example.to_do.Models.Users;
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
public class UserDTO {


    @Id
    @EqualsAndHashCode.Exclude
    String nome;
    String email;
    String senha;

    public UserDTO(Users user){
        this.nome = user.getNome();
        this.email = user.getSenha();
        this.senha = user.getSenha();
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
