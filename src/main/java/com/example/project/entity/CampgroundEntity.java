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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_campground_gen")
    @SequenceGenerator(name = "seq_campround_gen", sequenceName = "seq_campground", allocationSize = 1)
    private Long id;

    @Column
    private String name;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_categoryid", referencedColumnName = "id")
    private CategoryEntity category;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_locationid", referencedColumnName = "id")
    private LocationEntity location;

    @Column
    private int price;
}
