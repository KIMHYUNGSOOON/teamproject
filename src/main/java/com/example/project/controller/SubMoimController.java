package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubMoimController {
    @GetMapping("/html/submoim")
    public String sublodging() {
        return "html/submoim";
    }
}
