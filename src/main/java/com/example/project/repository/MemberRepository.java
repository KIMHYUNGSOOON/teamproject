package com.example.project.repository;


import com.example.project.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    boolean existsByLoginId(String loginId);
    boolean existsByNickname(String nickname);
    Optional<MemberEntity> findByLoginId(String loginId);
    MemberEntity findAllById(Long userId);
}
