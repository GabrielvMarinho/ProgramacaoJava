package net.weg.banco.repository;

import net.weg.banco.models.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
//    List<Conta> findByTitular_NomeContainsAndNumeroOrderByNumero(String nome, Integer numero);

    List<Conta> findBySaldoBetween(Double min, Double max);



}
