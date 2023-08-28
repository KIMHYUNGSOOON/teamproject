package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubLodgingController {
    @GetMapping("/html/sublodging")
    public String lodging(){
        return "/html/sublodging";
    }
}