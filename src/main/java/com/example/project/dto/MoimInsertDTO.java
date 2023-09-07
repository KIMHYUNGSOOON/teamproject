package com.example.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MoimInsertDTO {
    private Long userId;
    private String title;
    private String content;
}
