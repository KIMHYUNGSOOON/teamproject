package com.example.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CampgroundSearchDTO {
    //유저가 선택한 카테고리 메뉴
    private Long categoryId;

    //유저가 입력한 캠핑장이름
    private String campgroundName;

    //유저가 입력한 날짜
    private String date;

    //유저가 입력한 장소
    private String location_name;
}
