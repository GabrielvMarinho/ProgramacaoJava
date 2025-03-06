package com.example.demo;

import ch.qos.logback.core.net.server.Client;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class clienteCrud {

    @Autowired
    private userRepository repository;



    @GetMapping()
    public List<Users> selectUsers(User user){
//        List<Users> userss = repository.findAll();
//        System.out.println(userss);
        return repository.findAll();
    }

    @PostMapping()
    public Users insertUser(@RequestParam String name, @RequestParam boolean status) {
        System.out.println(name);
        System.out.println(status);

        Users user = new Users(name, status);
        System.out.println(user);
        return repository.save(user);
    }

}
