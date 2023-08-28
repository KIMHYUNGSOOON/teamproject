package com.example.project.repository;

import com.example.project.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    MemberEntity findByUserid(String userid);
}
