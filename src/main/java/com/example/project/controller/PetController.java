package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PetController {
    @GetMapping("/html/pet")
    public String lodging(){
        return "/html/pet";
    }
}
