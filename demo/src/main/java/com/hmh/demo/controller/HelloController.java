package com.hmh.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index(){
        return "from zero to expert";
    }

    @GetMapping("/fromZerotoExpert")
    public String fromZerotoExpert (){
        return "嗨，欢迎您来到 from zero to expert.";
    }
}
