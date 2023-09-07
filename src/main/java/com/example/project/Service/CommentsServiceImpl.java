package com.example.project.Service;


import com.example.project.dto.CommentsInsertDTO;
import com.example.project.entity.CommentsEntity;
import com.example.project.repository.CommentsRepository;
import com.example.project.repository.MemberRepository;
import com.example.project.repository.WritelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService{
    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    WritelistRepository writelistRepository;
    @Autowired
    MemberRepository memberRepository;
    @Override
    public List<CommentsEntity> getCommentsList(Long moimId) {
        return commentsRepository.findByWritelist_IdOrderByIdAsc(moimId);
    }

    @Override
    public void insertComment(CommentsInsertDTO dto) {
        CommentsEntity comment = new CommentsEntity();

        comment.setWritelist(writelistRepository.findAllById(dto.getWritelistId()));
        comment.setMember(memberRepository.findAllById(dto.getUserId()));
        comment.setContent(dto.getContent());

        commentsRepository.save(comment);
    }
}