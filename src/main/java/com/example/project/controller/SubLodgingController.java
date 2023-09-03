package com.example.project.controller;

import com.example.project.Service.LodgingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubLodgingController {
    @Autowired
    LodgingService lodgingService;
    @GetMapping("/html/sublodging")
    public String subLodging(Long itemId, Model model){

        model.addAttribute("campground", lodgingService.getCampground(itemId));

        return "/html/sublodging";
    }
}
