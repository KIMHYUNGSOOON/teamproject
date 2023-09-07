package com.example.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentsInsertDTO {
    private Long writelistId;
    
    private Long userId;

    private String content;
}
