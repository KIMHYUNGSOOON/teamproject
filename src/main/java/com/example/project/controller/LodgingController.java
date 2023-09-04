package com.example.project.controller;

import com.example.project.Service.LodgingService;
import com.example.project.dto.CampgroundSearchDTO;
import com.example.project.entity.CampgroundEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        List<CampgroundEntity> itemList = lodgingService.getItemList(dto);
        if(itemList.isEmpty()){
            //검색결과가 없을경우
            model.addAttribute("categoryId", dto.getCategoryId());
        }else{
            //검색결과가 있을경우
            model.addAttribute("itemList", itemList);
        }

        model.addAttribute("categoryList", lodgingService.getCategoryList());
        return "/html/lodging";
    }


}
