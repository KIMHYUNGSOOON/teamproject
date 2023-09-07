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
@Table(name = "writelist")
public class WritelistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_writelist_gen")
    @SequenceGenerator(name = "seq_writelist_gen", sequenceName = "seq_writelist", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_memberid", referencedColumnName = "id")
    private MemberEntity member;

    @Column
    private String title;

    @CreationTimestamp
    @Column
    private Date writedate;

    @Column
    private Long counting_view;

    @Column
    private String content;

    @Column
    private String mainImg;

    @Column
    private String subImg1;

    @Column
    private String subImg2;

    @Column
    private String subImg3;

    @Column
    private String subImg4;
}
