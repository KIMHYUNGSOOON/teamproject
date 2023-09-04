package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TipController {
    @GetMapping("/html/tip")
    public String sublodging() {
        return "html/tip";
    }
}
