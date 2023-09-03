package com.example.project.Service;

import com.example.project.dto.CampgroundSearchDTO;
import com.example.project.entity.CampgroundEntity;
import com.example.project.entity.CategoryEntity;

import java.util.List;

public interface LodgingService {

    public List<CategoryEntity> getCategoryList();
    // public List<CategoryEntity> getItemList(String campgroundName, Date date, String location_name);
    public List<CampgroundEntity> getItemList(CampgroundSearchDTO dto);

    public CampgroundEntity getCampground(Long id);
}
