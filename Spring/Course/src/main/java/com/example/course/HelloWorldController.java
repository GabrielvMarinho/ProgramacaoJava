package com.example.course;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/api")
    public String returnName(){
        return "gabriel";
    }
}
