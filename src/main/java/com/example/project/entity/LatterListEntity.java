package com.example.project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name ="latterlist")
public class LatterListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_latterlist_gen")
    @SequenceGenerator(name = "seq_latterlist_gen",sequenceName ="seq_latterlist",allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_memberid",referencedColumnName = "id")
    private MemberEntity member;

    @CreationTimestamp
    @Column
    private Date latterdate;

    @Column
    private Long counting_view;

    @Column
    private String content;

    @Column
    private String latterImg0;

    @Column
    private String latterImg1;

    @Column
    private String latterImg2;

    @Column
    private String latterImg3;
}