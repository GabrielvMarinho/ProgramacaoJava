package com.example.demo.model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_pf")
public class PJuridica extends Cliente{
    private Long cpnj;
    private String razaoSocial;

}
