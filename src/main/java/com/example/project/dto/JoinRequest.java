package com.example.project.dto;


import com.example.project.domain.UserRole;
import com.example.project.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class JoinRequest {

    @NotBlank(message = "아이디는 필수입력란입니다.")
    private String loginId;
    @NotBlank(message = "이름은 필수입력란입니다")
    private String name;
    @NotBlank(message = "비밀번호는 필수입력란입니다.")
    private String password;
    private String passwordCheck;
    @NotBlank(message = "이메일은 필수입력란입니다.")
    private String email;
    @NotBlank(message = "닉네임은 필수입력란입니다.")
    private String nickname;
    @NotBlank(message = "전화번호는 필수입력란입니다.")
    private String phone;
    @NotBlank(message = "성별은 필수 체크 사항입니다.")
    private String gender;

    // 비밀번호 암호화
    public MemberEntity toEntity(String encodedPassword) {
        return MemberEntity.builder()
                .loginId(this.loginId)
                .name(this.name)
                .password(encodedPassword)
                .email(this.email)
                .nickname(this.nickname)
                .phone(this.phone)
                .gender(this.gender)
                .role(UserRole.USER)
                .build();
    }
}

