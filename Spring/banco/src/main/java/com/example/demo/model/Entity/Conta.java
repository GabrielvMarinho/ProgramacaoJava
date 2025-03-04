package com.example.demo.model.Entity;

import com.example.demo.model.DTO.ClienteContaGetResponseDTO;
import com.example.demo.model.DTO.ContaClienteResponseDTO;
import com.example.demo.model.DTO.ContaResponseDTO;
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

//    @ManyToMany(mappedBy = "contas")
    //    private List<Cliente> titulares;
//    @OneToOne
//    private Cliente titular;
    @ManyToOne
    private Cliente titular;

    @ToString.Exclude //excludes this attribute of the toString
    @Builder.Default
    private Double saldo=0.0;

    private Double limite;


    public ContaResponseDTO convert() {
        return new ContaResponseDTO(
                this.id,
                this.numero,
                this.saldo,
                this.limite,
                this.titular.convertToClienteContaResponseDTO()
        );
    }

    public ContaClienteResponseDTO convertToContaClienteResponseDTO(){
        return new ContaClienteResponseDTO(this.id, this.saldo,
                this.limite, this.numero);
    }

    public ContaResponseDTO convertToContaResponseDTO() {
        ClienteContaGetResponseDTO titular = this.titular.convertToClienteContaResponseDTO();
        return new ContaResponseDTO(this.id, this.numero, this.saldo, this.limite, titular);
    }
}