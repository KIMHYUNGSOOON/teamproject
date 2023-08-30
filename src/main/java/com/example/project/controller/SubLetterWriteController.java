package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubLetterWriteController {
    @GetMapping("/html/sublatterwrite")
    public String sublodging() {
        return "html/sublatterwrite";
    }

}
