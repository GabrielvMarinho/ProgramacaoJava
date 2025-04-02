package br.senai.sc.security.sec.model.dto;

import lombok.Data;

public record LoginDto (
        String username,
        String password
){
}
