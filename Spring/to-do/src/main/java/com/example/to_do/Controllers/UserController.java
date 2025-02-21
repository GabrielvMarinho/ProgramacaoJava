package com.example.to_do.Controllers;

import com.example.to_do.DTOs.UserDTO;
import com.example.to_do.Models.Users;
import com.example.to_do.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> selectUser(){
        return ResponseEntity.ok(userService.selectUser());
    }

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody Users user){
        return ResponseEntity.ok(userService.createUser(user).toString());
    }
    @PutMapping("/user")
    public ResponseEntity<String> updateUser(@RequestParam Long id, @RequestBody Users user){
        return ResponseEntity.ok(userService.updateUser(id, user).toString());
    }
    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUser(@RequestParam Long id){
        return ResponseEntity.ok(userService.deleteUser(id).toString());
    }
}
