package com.example.project.dto;

import com.example.project.domain.Role;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor

@ToString
public class MemberDTO {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String userid;

    @NotEmpty(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
    private String pwd;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
    private String pwd1;

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @NotEmpty(message = "전화번호는 필수 입력 값입니다.")
    private String tel;

    @NotEmpty(message = "성별는 필수 입력 값입니다.")
    private String gender;

    @Builder
    public MemberDTO(String userid, String name, String pwd, String pwd1, String email, String tel, String gender) {
        this.userid = userid;
        this.name = name;
        this.pwd = pwd;
        this.pwd1 = pwd1;
        this.email = email;
        this.tel = tel;
        this.gender = gender;
    }

}
