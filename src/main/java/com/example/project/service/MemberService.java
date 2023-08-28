package com.example.project.service;

import com.example.project.dto.MemberDTO;
import com.example.project.entity.MemberEntity;
import com.example.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberEntity saveMember(MemberEntity memberEntity) {
        validateDuplicateMember(memberEntity);
        return  memberRepository.save(memberEntity);
    }

    private void validateDuplicateMember(MemberEntity memberEntity) {
        MemberEntity findMemberEntity = memberRepository.findByUserid(memberEntity.getUserid());
        if(findMemberEntity != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
