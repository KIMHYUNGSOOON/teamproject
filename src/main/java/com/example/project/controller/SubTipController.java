package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubTipController {
    @GetMapping("/html/subtip")
    public String sublodging() {
        return "html/subtip";
    }

    @GetMapping("/html/subtipa")
    public String sublodginga() {
        return "html/subtipa";
    }

    @GetMapping("/html/subtipb")
    public String sublodgingb() {
        return "html/subtipb";
    }

    @GetMapping("/html/subtipc")
    public String sublodgingc() {
        return "html/subtipc";
    }

    @GetMapping("/html/subtipd")
    public String sublodgingd() {
        return "html/subtipd";
    }

    @GetMapping("/html/subtipe")
    public String sublodginge() {
        return "html/subtipe";
    }

    @GetMapping("/html/subtipf")
    public String sublodgingf() {
        return "html/subtipf";
    }
    @GetMapping("/html/subtipg")
    public String sublodgingg() {
        return "html/subtipg";
    }

}

