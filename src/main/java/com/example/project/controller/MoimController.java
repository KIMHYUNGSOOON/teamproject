package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MoimController {
    @GetMapping("/html/moim")
    public String moim(){
        return "/html/moim";
    }
}
