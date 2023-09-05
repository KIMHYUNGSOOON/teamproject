package com.example.project.repository;

import com.example.project.entity.WritelistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WritelistRepository extends JpaRepository<WritelistEntity, Long> {
    List<WritelistEntity> findTop2ByOrderByWritedateDesc();
}
