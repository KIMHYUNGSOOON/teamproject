package com.example.project.Service;

import com.example.project.dto.CommentsInsertDTO;
import com.example.project.entity.CommentsEntity;

import java.util.List;

public interface CommentsService {

    List<CommentsEntity> getCommentsList(Long moimId);

    void insertComment(CommentsInsertDTO dto);
}
