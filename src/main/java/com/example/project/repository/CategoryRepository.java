package com.example.project.repository;

import com.example.project.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CategoryRepository  extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity>  findAllByOrderByIdAsc();
}