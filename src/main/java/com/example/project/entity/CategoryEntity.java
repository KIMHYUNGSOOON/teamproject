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
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category_gen")
    @SequenceGenerator(name = "seq_category_gen", sequenceName = "seq_category", allocationSize = 1)
    private Long id;

    @Column
    private String name;

    @Builder
    public CategoryEntity(Long id, String name){
        this.id =id;
        this.name =name;
    }
}
