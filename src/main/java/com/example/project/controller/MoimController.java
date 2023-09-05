package com.example.project.controller;

import com.example.project.Service.MoimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MoimController {

    @Autowired
    MoimService moimService;

    @GetMapping("/html/moim")
    public String moim(Model model){

        model.addAttribute("moimList", moimService.getMoimListTop2());

        return "/html/moim";
    }
}
