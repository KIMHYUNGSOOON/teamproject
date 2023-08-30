package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubTipController {
    @GetMapping("/html/subtip")
    public String sublodging() {
        return "html/subtip";
    }
}
