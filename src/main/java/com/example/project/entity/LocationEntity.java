package com.example.project.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "location")
public class LocationEntity {
    // 프라이머리 키 설정한 변수
    @Id
    // 프라이머리 키인 id에는 자동 생성된 값을 주겠다고 선언 (시퀀스)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_location_gen")
    // ↑ 자동 생성된 값을 주겠다고 선언 -> 자동 생성은 어떻게 할것인지 설정한 값으로 시퀀스 값 넣기 sequenceName은 DB에서 생성한 시퀀스명이 들어감
    @SequenceGenerator(name = "seq_location_gen", sequenceName = "LOCATION_INFO_SEQ", allocationSize = 1)
    // DB에 있는 프라이머리키 컬럼과 동일하게 설정하기
    private Long id;

    // 일반적인 컬럼이라는 뜻
    @Column
    private String location;

    @Builder
    public LocationEntity(Long id, String location){
        this.id =id;
        this.location =location;
    }
}
