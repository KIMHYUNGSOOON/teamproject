package com.example.project.Service;

import com.example.project.entity.WritelistEntity;
import com.example.project.repository.WritelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MoimServiceImpl implements MoimService{
    @Autowired
    WritelistRepository writelistRepository;
    public List<WritelistEntity> getMoimListTop2(){
        return writelistRepository.findTop2ByOrderByWritedateDesc();
    }
}
