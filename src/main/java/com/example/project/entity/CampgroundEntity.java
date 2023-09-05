package com.example.project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "campground")
public class CampgroundEntity {
    // 프라이머리 키 설정한 변수
    @Id
    // 프라이머리 키인 id에는 자동생성된 값을 주겠다고 선언 (시퀀스)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_campground_gen")
    // ↑ 자동 생성된 값을 주겠다고 선언 -> 자동 생성은 어떻게 할것인지 설정한 값으로 시퀀스 값 넣기 sequenceName은 DB에서 생성한 시퀀스명이 들어감
    @SequenceGenerator(name = "seq_campround_gen", sequenceName = "seq_campground", allocationSize = 1)
    // DB에 있는 프라이머리키 컬럼과 동일하게 설정하기
    private Long id;

    @Column
    private String name;

    // Campground테이블은 Category를 외부키로 주고 있음 (references하고 있음)
    // spring에서는 CampgroundEntitiy에는 CategoryEntity를 갖고 있다고 표현해야함
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_categoryid", referencedColumnName = "id")
    private CategoryEntity category;

    // ↑ 동일함
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_locationid", referencedColumnName = "id")
    private LocationEntity location;

    @Column
    private int price;
}
