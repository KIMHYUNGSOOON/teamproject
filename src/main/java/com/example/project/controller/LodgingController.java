package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LodgingController {
    @GetMapping("/html/lodging")
    public String lodging(){
        return "/html/lodging";
    }
}
