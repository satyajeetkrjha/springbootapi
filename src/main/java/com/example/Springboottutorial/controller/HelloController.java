package com.example.Springboottutorial.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @RequestMapping(value="/",method = RequestMethod.GET)
    @GetMapping("/")
    public String helloworld(){
       return "This is a basic code";
    }
}
