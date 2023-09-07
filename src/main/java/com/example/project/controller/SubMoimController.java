package com.example.project.controller;

import com.example.project.Service.CommentsService;
import com.example.project.Service.MoimService;
import com.example.project.dto.CommentsInsertDTO;
import com.example.project.dto.MoimInsertDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SubMoimController {
    @Autowired
    MoimService moimService;

    @Autowired
    CommentsService commentsService;

    @GetMapping("/html/submoim")
    public String sublodging(Long moimId, Model model) {
        System.out.println("일단 들어왔따~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("전달받은 모임아이디 : " + moimId);
        //조회수 더해주기
        moimService.addMoimCountingView(moimId);
        model.addAttribute("moim", moimService.getMoim(moimId));
        model.addAttribute("commentsList",commentsService.getCommentsList(moimId));
        return "html/submoim";
    }

    @PostMapping("/html/submoim")
    public String commentInsert(CommentsInsertDTO dto, Model model){
        commentsService.insertComment(dto);
        return sublodging(dto.getWritelistId(), model);
    }

    @GetMapping("/html/writemoim")
    public String writemoim() {
        return "html/writemoim";
    }

    @PostMapping("/html/writeInsert")
    public String writeinsert(@RequestParam("userImg") MultipartFile[] uploadFile, MoimInsertDTO dto, Model model) {
        moimService.writeInsert(uploadFile, dto);
        model.addAttribute("moimList", moimService.getMoimListAll());
        return "html/moim";
    }

}
