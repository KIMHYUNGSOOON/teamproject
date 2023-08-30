package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubLetterFixController {
    @GetMapping("/html/sublatterfix")
    public String sublodging() {
        return "html/sublatterfix";
    }

}
