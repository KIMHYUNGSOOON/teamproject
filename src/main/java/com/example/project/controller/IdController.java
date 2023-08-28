package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IdController {
    @GetMapping("/Id")
    public String showIdPage() {
        return "Id"; // Member.html 파일을 참조
    }
}
