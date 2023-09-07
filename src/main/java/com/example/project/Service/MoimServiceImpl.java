package com.example.project.Service;

import com.example.project.dto.FileDTO;
import com.example.project.dto.MoimInsertDTO;
import com.example.project.entity.WritelistEntity;
import com.example.project.repository.MemberRepository;
import com.example.project.repository.WritelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MoimServiceImpl implements MoimService{
    @Autowired
    WritelistRepository writelistRepository;
    @Autowired
    MemberRepository memberRepository;

    public List<WritelistEntity> getMoimListTop2(){
        return writelistRepository.findTop2ByOrderByWritedateDesc();
    }

    @Override
    public List<WritelistEntity> getMoimListAll() {
        return writelistRepository.findAllByOrderByWritedateDesc();
    }

    @Override
    public WritelistEntity getMoim(Long moimId) {
        return writelistRepository.findAllById(moimId);
    }

    @Override
    public Long addMoimCountingView(Long moimId){
        //조회수 더해주기
        WritelistEntity write = writelistRepository.findAllById(moimId);
        long count = write.getCounting_view();
        write.setCounting_view(++count);
        writelistRepository.save(write);
        return count;
    }

    @Override
    public void writeInsert(MultipartFile[] uploadFile, MoimInsertDTO dto) {
        //업로드 파일 저장 처리
        List<FileDTO> fileList = new ArrayList<>();
        for(MultipartFile file : uploadFile){
            if(!file.isEmpty()){
                //UUID이용, 유니크한 파일 이름 생성
                FileDTO fileDto = new FileDTO(UUID.randomUUID().toString(), file.getOriginalFilename(), file.getContentType());
                fileList.add(fileDto);

                File newFileName = new File(fileDto.getUuid() + "_" + fileDto.getFileName());
                try{
                    //물리적으로 저장해줌
                    file.transferTo(newFileName);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }

        WritelistEntity write = new WritelistEntity();
        write.setMember(memberRepository.findById(dto.getUserId()).get());
        write.setTitle(dto.getTitle());
        write.setContent(dto.getContent());
        write.setCounting_view(0L);

        if(fileList.size() > 0){
            //파일을 하나 이상 등록시
            switch(fileList.size()){
                case 5 : write.setSubImg4(fileList.get(4).getUuid() + "_" + fileList.get(4).getFileName());
                case 4 : write.setSubImg3(fileList.get(3).getUuid() + "_" + fileList.get(3).getFileName());
                case 3 : write.setSubImg2(fileList.get(2).getUuid() + "_" + fileList.get(2).getFileName());
                case 2 : write.setSubImg1(fileList.get(1).getUuid() + "_" + fileList.get(1).getFileName());
                case 1 : write.setMainImg(fileList.get(0).getUuid() + "_" + fileList.get(0).getFileName());
            }
        }

        writelistRepository.save(write);

    }
}
