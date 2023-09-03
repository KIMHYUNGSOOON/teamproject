package com.example.project.controller;

import com.example.project.Service.LodgingService;
import com.example.project.dto.CampgroundSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LodgingController {

    @Autowired
    LodgingService lodgingService;
    @GetMapping("/html/lodging")
    public String lodging(Long category, Model model){

        model.addAttribute("categoryList", lodgingService.getCategoryList());
        CampgroundSearchDTO dto = new CampgroundSearchDTO();
        dto.setCategoryId(category);
        model.addAttribute("itemList", lodgingService.getItemList(dto));
        return "/html/lodging";
    }

    @PostMapping("/lodging/search")
    public String search(CampgroundSearchDTO dto, Model model){
        model.addAttribute("itemList", lodgingService.getItemList(dto));
        model.addAttribute("categoryList", lodgingService.getCategoryList());
        return "/html/lodging";
    }


}
