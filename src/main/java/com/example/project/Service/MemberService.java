package com.example.project.service;

import com.example.project.dto.MemberDTO;
import com.example.project.entity.MemberEntity;
import com.example.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional  // 로직을 처리하다가 에러가 발생하였다면, 변경된 데이터를 로직을 수행하기 이전 상태로 콜백
@RequiredArgsConstructor
public class MemberService implements UserDetailsService  {
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
    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {

        MemberEntity memberEntity = memberRepository.findByUserid(userid);

        if(memberEntity == null){
            throw new UsernameNotFoundException(userid);
        }

        return User.builder()
                .username(memberEntity.getUserid())
                .password(memberEntity.getPwd())
                .roles(memberEntity.getRole().toString())
                .build();
    }
}