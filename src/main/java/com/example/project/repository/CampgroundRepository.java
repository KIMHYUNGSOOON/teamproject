package com.example.project.repository;

import com.example.project.entity.CampgroundEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampgroundRepository extends JpaRepository<CampgroundEntity, Long> {

    CampgroundEntity findByName(String name);

    List<CampgroundEntity> findDistinctByFk_categoryIdContainingOrNameContaining(String categoryId, String name);
}
