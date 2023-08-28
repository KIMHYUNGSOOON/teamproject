package com.example.project.entity;


import com.example.project.domain.Role;
import com.example.project.dto.MemberDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private  String userid;
    @Column
    private String name;
    @Column
    private String pwd;
    @Column
    private String pwd1;
    @Column
    private String email;
    @Column
    private String tel;
    @Column
    private String gender;
    @Enumerated(EnumType.STRING)
    private Role role;

 @Builder
 public MemberEntity(String userid, String name, String pwd, String pwd1, String email, String tel, String gender, Role role){
     this.userid =userid;
     this.name =name;
     this.pwd =pwd;
     this.pwd1 =pwd1;
     this.email =email;
     this.tel =tel;
     this.gender =gender;
     this.role = role;
 }


    public static MemberEntity createMember(MemberDTO memberDTO, PasswordEncoder passwordEncoder) {
        MemberEntity memberEntity = MemberEntity.builder()
                .userid(memberDTO.getUserid())
                .name(memberDTO.getName())
                .pwd(passwordEncoder.encode(memberDTO.getPwd()))
                .pwd1(passwordEncoder.encode(memberDTO.getPwd1()))
                .email(memberDTO.getEmail())
                .tel(memberDTO.getTel())
                .gender(memberDTO.getGender())
                .role(Role.User) // Role을 어떻게 사용하는지에 따라 수정 필요
                .build();
        return memberEntity;
    }
}


