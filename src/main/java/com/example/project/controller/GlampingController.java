package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlampingController {
    @GetMapping("/html/glamping")
    public String lodging(){
        return "/html/glamping";
    }
}
