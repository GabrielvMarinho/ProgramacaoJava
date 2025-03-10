package com.example.demo.model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_pj")
public class PFisica extends Cliente {
    private String nome2;
    private Long cpf2;
}
