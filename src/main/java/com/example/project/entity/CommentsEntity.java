package com.example.project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "comments")
public class CommentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comments_gen")
    @SequenceGenerator(name = "seq_comments_gen", sequenceName = "seq_comments", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_memberId", referencedColumnName = "id")
    private MemberEntity member;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_writelistId", referencedColumnName = "id")
    private WritelistEntity writelist;


    @Column
    private String content;
}
