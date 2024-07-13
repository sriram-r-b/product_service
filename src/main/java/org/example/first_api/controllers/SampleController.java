package org.example.first_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SampleController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
    @GetMapping("/bye/{name}")
    public String bye(@PathVariable("name") String name){
        return "Hello "+name;
    }
}
