package com.signApi.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class IndexController {
    @GetMapping("/")
    public Resource getIndex(){
        return new ClassPathResource("/login.html");
    }

    @GetMapping("/success")
    public String success(){
        return "Hello World!";
    }

    @GetMapping("/fail")
    public String fail(){
        return "실패임";
    }
}
