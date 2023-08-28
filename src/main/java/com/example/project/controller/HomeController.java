package com.example.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {
// 기본 페이지 요청 메소드
    @GetMapping(value = "/")
    public String Login(){
        return "Login"; // Login.html 찾아감
    }
}


