package com.example.project.Service;


import com.example.project.dto.CampgroundSearchDTO;
import com.example.project.entity.CampgroundEntity;
import com.example.project.entity.CategoryEntity;
import com.example.project.repository.CampgroundRepository;
import com.example.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LodgingServiceImpl implements LodgingService{
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CampgroundRepository campgroundRepository;

    @Override
    public List<CategoryEntity> getCategoryList() {
        return  categoryRepository.findAllByOrderByIdAsc();
    }

    @Override
    public List<CampgroundEntity> getItemList(CampgroundSearchDTO dto) {
        List<CampgroundEntity> camp = new ArrayList<>();

        //&으로 나누기
        if((dto.getLocation_name() != null && !dto.getLocation_name().isEmpty()) || (dto.getCampgroundName() != null && !dto.getCampgroundName().isEmpty())){
            //검색으로 들어온 경우
            if(dto.getLocation_name() != null && !dto.getLocation_name().isEmpty()){
                //장소만 입력 혹은 장소 + 캠핑장명 입력시
                String[] locationArr = dto.getLocation_name().split("&");
                if(locationArr.length > 1){
                    camp = campgroundRepository.findDistinctByCategory_IdAndNameContainingAndLocation_LocationInOrderByIdAsc(dto.getCategoryId(), dto.getCampgroundName(), locationArr);
                }else{
                    //&으로 안되어있으면
                    camp = campgroundRepository.findDistinctByCategory_IdAndLocation_LocationAndNameContainingOrderByIdAsc(dto.getCategoryId(), dto.getLocation_name(), dto.getCampgroundName());
                }
            }else{
                //캠핑장명만 입력시
                camp = campgroundRepository.findDistinctByCategory_IdAndNameContainingOrderByIdAsc(dto.getCategoryId(),dto.getCampgroundName());
            }
        }else{
            //인덱스에서 들어온 경우
            CategoryEntity cate = new CategoryEntity();
            cate.setId(dto.getCategoryId());
            camp = campgroundRepository.findByCategory(cate);
        }
        return camp;
    }

    @Override
    public CampgroundEntity getCampground(Long id){
        return campgroundRepository.getById(id);
    }
}