package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {
    @GetMapping("/html/notice")
    public String lodging(){
        return "/html/notice";
    }

    @GetMapping("/html/subnotice")
    public String subnotice(){
        return "/html/subnotice";
    }
}
