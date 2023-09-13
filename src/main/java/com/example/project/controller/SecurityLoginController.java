package com.example.project.controller;


import com.example.project.Service.LodgingService;
import com.example.project.Service.MoimService;
import com.example.project.Service.UserService;
import com.example.project.dto.JoinRequest;
import com.example.project.dto.LoginRequest;
import com.example.project.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
/*@RequestMapping("/security-login")*/
public class SecurityLoginController {

    @Autowired
    LodgingService lodgingService;

    @Autowired
    MoimService moimService;

    private final UserService userService;

    @GetMapping(value = {"", "/"})
    public String index(Model model, Authentication auth, HttpSession session) {
        model.addAttribute("loginType", "security-login");
        model.addAttribute("pageName", "Security 로그인");

        if(auth != null) {
            MemberEntity loginUser = userService.getLoginUserByLoginId(auth.getName());
            if (loginUser != null) {
                model.addAttribute("name", loginUser.getName());
                //0906 추가분(?) by shin
                session.setAttribute("loginUser", loginUser);
            }
        }
       model.addAttribute("categoryList", lodgingService.getCategoryList());
       model.addAttribute("moimList", moimService.getMoimListTop2());

        return "/html/index";
    }

    @GetMapping("/html/join")
    public String joinPage(Model model) {
        model.addAttribute("loginType", "security-login");
        model.addAttribute("pageName", "Security 로그인");

        model.addAttribute("joinRequest", new JoinRequest());
        return "/html/join";
    }

    @PostMapping("/html/join")
    public String join(@Valid @ModelAttribute JoinRequest joinRequest, BindingResult bindingResult, Model model) {
        model.addAttribute("loginType", "security-login");
        model.addAttribute("pageName", "Security 로그인");

        // loginId 중복 체크
        if(userService.checkLoginIdDuplicate(joinRequest.getLoginId())) {
            bindingResult.addError(new FieldError("joinRequest", "loginId", "로그인 아이디가 중복됩니다."));
        }
        // 닉네임 중복 체크
        if(userService.checkNicknameDuplicate(joinRequest.getNickname())) {
            bindingResult.addError(new FieldError("joinRequest", "nickname", "닉네임이 중복됩니다."));
        }

        // password와 passwordCheck가 같은지 체크
        if(!joinRequest.getPassword().equals(joinRequest.getPasswordCheck())) {
            bindingResult.addError(new FieldError("joinRequest", "passwordCheck", "바밀번호가 일치하지 않습니다."));
        }

        if(bindingResult.hasErrors()) {
            return "/html/join";
        }

        userService.join2(joinRequest);
        return "redirect:/html/login";
    }

    @GetMapping("/html/login")
    public String loginPage(Model model) {
        model.addAttribute("loginType", "security-login");
        model.addAttribute("pageName", "Security 로그인");

        model.addAttribute("loginRequest", new LoginRequest());
        return "/html/login";
    }

    @GetMapping("/html/info")
    public String userInfo(Model model, Authentication auth) {
        model.addAttribute("loginType", "security-login");
        model.addAttribute("pageName", "Security 로그인");

        MemberEntity loginUser = userService.getLoginUserByLoginId(auth.getName());

        if(loginUser == null) {
            return "redirect:/html/login";
        }

        model.addAttribute("user", loginUser);
        return "/html/info";
    }

    @GetMapping("/html/admin")
    public String adminPage( Model model) {
        model.addAttribute("loginType", "security-login");
        model.addAttribute("pageName", "Security 로그인");

        return "/html/admin";
    }
}
