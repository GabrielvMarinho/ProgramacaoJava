package com.example.demo.model.mapper;

import com.example.demo.model.DTO.ContaClienteResponseDTO;
import com.example.demo.model.DTO.ContaResponseDTO;
import com.example.demo.model.DTO.ContaPostRequestDTO;
import com.example.demo.model.Entity.Conta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContaMapper {
    ContaMapper INSTANCE = Mappers.getMapper(ContaMapper.class);

    ContaResponseDTO contaToContaGeTResponseDTO(Conta conta);

    ContaClienteResponseDTO contaToContaClienteResponseDTO(Conta conta);

    ContaPostRequestDTO contaToContaPostRequestDTO(Conta conta);
}
