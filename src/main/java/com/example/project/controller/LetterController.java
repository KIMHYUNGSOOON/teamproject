package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LetterController {
    @GetMapping("/html/latter")
    public String lodging(){
        return "/html/latter";
    }
}
