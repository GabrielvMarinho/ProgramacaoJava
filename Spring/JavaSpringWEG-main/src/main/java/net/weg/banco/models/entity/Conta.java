package net.weg.banco.models.entity;

import jakarta.persistence.*;
import lombok.*;
import net.weg.banco.models.dtos.ClienteContaResponseDTO;
import net.weg.banco.models.dtos.ContaClienteResponseDTO;
import net.weg.banco.models.dtos.ContaResponseDTO;

@Data
@Entity
@AllArgsConstructor
@Table(name = "tb_conta")
@NoArgsConstructor
@Builder
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "numero_da_conta",
    nullable = false,
    unique = true)
    private Integer numero;

    @ManyToOne
    private Cliente titular;

    @Builder.Default
    private Double saldo = 0.0;
    private Double limite;

    public ContaClienteResponseDTO convertToContaClienteResponseDTO() {
        return new ContaClienteResponseDTO(id, saldo, limite, numero);
    }

    public ContaResponseDTO convertToContaResponseDTO() {
        ClienteContaResponseDTO titular = this.titular.convertToClienteContaResponseDTO();
        return new ContaResponseDTO(id, numero, saldo, limite, titular);
    }
}
