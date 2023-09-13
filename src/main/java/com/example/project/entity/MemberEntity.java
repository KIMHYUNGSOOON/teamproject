package com.example.project.entity;


import com.example.project.domain.UserRole;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="MEMBER")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId;
    private String name;
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String gender;

    private UserRole role;


    private String provider;
    private String providerId;

}
