package com.example.project.repository;

import com.example.project.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<CommentsEntity, Long> {
    List<CommentsEntity> findByWritelist_IdOrderByIdAsc(Long writelistId);
}
