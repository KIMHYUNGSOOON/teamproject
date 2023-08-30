package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubLetterController {
    @GetMapping("/html/sublatter")
    public String lodging(){
        return "/html/sublatter";
    }
}
