package com.example.project.controller;

import com.example.project.entity.CampgroundEntity;
import com.example.project.repository.CampgroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampgroundController {

    @Autowired
    private CampgroundRepository campgroundRepository;

    @GetMapping("/campgrounds")
    public CampgroundEntity getCampgroundByName(@RequestParam String name) {
        return campgroundRepository.findByName(name);
    }
}