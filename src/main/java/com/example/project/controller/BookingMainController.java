package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingMainController {
    @GetMapping("/html/bookingmain")
    public String lodging(){
        return "/html/bookingmain";
    }
}
