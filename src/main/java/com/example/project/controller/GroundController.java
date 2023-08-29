package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroundController {
    @GetMapping("/html/ground")
    public String lodging(){
        return "/html/ground";
    }
}
