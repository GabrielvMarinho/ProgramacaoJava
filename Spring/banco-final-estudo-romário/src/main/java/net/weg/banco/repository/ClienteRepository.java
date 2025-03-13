package net.weg.banco.repository;

import net.weg.banco.models.entity.Cliente;
import net.weg.banco.models.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByNome(String nome);
}
