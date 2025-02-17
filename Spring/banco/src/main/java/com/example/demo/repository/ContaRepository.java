package com.example.demo.repository;

import com.example.demo.model.Conta;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
