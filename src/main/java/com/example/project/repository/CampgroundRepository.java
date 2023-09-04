package com.example.project.repository;

import com.example.project.entity.CampgroundEntity;
import com.example.project.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampgroundRepository extends JpaRepository<CampgroundEntity, Long> {

    CampgroundEntity findByName(String name);

    List<CampgroundEntity> findDistinctByCategory_IdAndLocation_LocationAndNameContainingOrderByIdAsc(Long CategoryId, String location, String campgroundName);

    List<CampgroundEntity> findDistinctByCategory_IdAndNameContainingOrderByIdAsc(Long CategoryId, String campgroundName);


    List<CampgroundEntity> findDistinctByCategory_IdAndNameContainingAndLocation_LocationInOrderByIdAsc(Long CategoryId, String campgroundName, String[] location);

    CampgroundEntity getById(Long id);

    List<CampgroundEntity> findByCategory(CategoryEntity category);
}
