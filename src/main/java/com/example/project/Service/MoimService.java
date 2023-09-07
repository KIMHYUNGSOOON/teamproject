package com.example.project.Service;

import com.example.project.dto.MoimInsertDTO;
import com.example.project.entity.WritelistEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MoimService {

    public List<WritelistEntity> getMoimListTop2();

    public List<WritelistEntity> getMoimListAll();

    public WritelistEntity getMoim(Long moimId);

    public Long addMoimCountingView(Long moimId);

    void writeInsert(MultipartFile[] uploadFile, MoimInsertDTO dto);
}
