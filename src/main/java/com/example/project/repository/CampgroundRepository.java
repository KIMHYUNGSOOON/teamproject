package com.example.project.repository;

import com.example.project.entity.CampgroundEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampgroundRepository extends JpaRepository<CampgroundEntity, Long> {

    CampgroundEntity findByName(String name);
}
