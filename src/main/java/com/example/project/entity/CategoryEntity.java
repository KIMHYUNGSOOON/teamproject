package com.example.project.entity;

import com.example.project.domain.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "category")
public class CategoryEntity {
    @Id
    private Long id;
    @Column
    private String name;

    @Builder
    public CategoryEntity(Long id, String name){
        this.id =id;
        this.name =name;
    }
}
