package com.example.project.controller;

import com.example.project.Service.MoimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoimController {

    @Autowired
    MoimService moimService;

    @GetMapping("/html/moim")
    public String moim(Model model){

        model.addAttribute("moimList", moimService.getMoimListAll());
        return "/html/moim";
    }


    @CrossOrigin
    @GetMapping("/image")
    public ResponseEntity<?> returnImage(@RequestParam String image) {
        //유저가 업로드한 이미지를 return
        String path = "C:\\Users\\Class01\\IdeaProjects\\teamproject\\src\\main\\resources\\static\\img\\writemoim_img\\"; //이미지가 저장된 위치
        Resource resource = new FileSystemResource(path + image);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
}
