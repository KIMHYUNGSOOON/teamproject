package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PwdController {
    @GetMapping("/Pwd")
    public String showPwdPage() {
        return "Pwd"; // Member.html 파일을 참조
    }
}