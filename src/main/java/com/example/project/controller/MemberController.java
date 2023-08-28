package com.example.project.controller;

import com.example.project.dto.MemberDTO;


import com.example.project.entity.MemberEntity;
import com.example.project.service.MemberService;
import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
//@RequestMapping("/Member")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "Member")
    public String Member(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "Member";

    }
    @PostMapping(value = "/Login")
    public String Member(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.createMember(memberDTO, passwordEncoder);
        memberService.saveMember(memberEntity);

        return "redirect:/";
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



