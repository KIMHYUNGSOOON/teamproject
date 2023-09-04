package com.example.project.controller;

import com.example.project.dto.MemberDTO;


import com.example.project.entity.MemberEntity;
import com.example.project.service.MemberService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/new")
    public String Member(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "/html/Member";


    }
    @PostMapping(value = "/new")
    public String Member(@Valid MemberDTO memberDTO, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "/html/Member";
        }
        try {
            MemberEntity memberEntity = MemberEntity.createMember(memberDTO, passwordEncoder);
            memberService.saveMember(memberEntity);
        }catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "/html/Member";
        }
        return "redirect:/";
    }
    @GetMapping(value = "/login")
    public String loginMember(){
        return "Login";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "Login";
    }
}
/*
      //회원가입 페이지 출력 요청
    @GetMapping("/Member")
    public String showJoinPage() {
        return "Member"; // Member.html 파일을 참조
    }
}
/*
    @PostMapping("/Login")
    public String save(@ModelAttribute MemberDTO memberDTO){
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);

        MemberService.save(MemberDTO);
        return "Login";*/




