package com.example.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDTO {
    private String uuid; //unique한 파일 이름 만들기 위해 사용
    private String fileName;
    private String contentType;

    public FileDTO(){}
    public FileDTO(String uuid, String fileName, String contentType){
        this.uuid = uuid;
        this.fileName = fileName;
        this.contentType = contentType;
    }

}
