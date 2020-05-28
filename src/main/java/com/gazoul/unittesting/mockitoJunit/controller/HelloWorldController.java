package com.gazoul.unittesting.mockitoJunit.controller;

import com.gazoul.unittesting.mockitoJunit.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
