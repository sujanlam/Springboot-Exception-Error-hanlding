package com.excptn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class TestController {

    @GetMapping("/msg")
    public String getMessage(){
        return "Welcome to the app!!!";
    }
}
