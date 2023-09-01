package com.example.project.controller;

import com.example.project.Service.LodgingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LodgingController {

    @Autowired
    private LodgingServiceImpl lodgingService;
    @GetMapping("/html/lodging")
    public String lodging(Model model){

        model.addAttribute("categoryList", lodgingService.getCategoryList());

        return "/html/lodging";
    }

    /*@PostMapping("/lodging/search")
    public String search(Model model){

        model.addAttribute("itemList", lodgingService.getItemList());

        return "/html/lodging";
    }*/
}
