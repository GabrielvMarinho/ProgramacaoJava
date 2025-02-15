package com.example.to_do.Services;

import com.example.to_do.DTOs.UserDTO;
import com.example.to_do.Models.Users;
import com.example.to_do.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> selectUser(){
        //service business logic
        List<Users> list;
        list = userRepository.findAll();

        List<UserDTO> dtoList = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            dtoList.add(new UserDTO(list.get(i)));
        }
        return dtoList;
    }
    public UserDTO createUser(Users user){
        //service business logic
        userRepository.save(user);
        //turning model to dto
        UserDTO dto = new UserDTO(user);
        return dto;
    }
    public UserDTO updateUser(Long id, Users user){
        //service business logic
        Users userExistente = userRepository.findById(id).orElseThrow();
        userExistente.setNome(user.getNome());
        userExistente.setEmail(user.getEmail());
        userExistente.setSenha(user.getSenha());

        userRepository.save(userExistente);
        //turning model to dto
        UserDTO dto = new UserDTO(user);
        return dto;
    }
    public UserDTO deleteUser(Long id){
        //service business logic
        Users user = userRepository.findById(id).orElseThrow();
        UserDTO dto = new UserDTO(user);
        userRepository.delete(user);
        return dto;
    }
}
