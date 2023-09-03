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
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_location_gen")
    @SequenceGenerator(name = "seq_location_gen", sequenceName = "LOCATION_INFO_SEQ", allocationSize = 1)
    private Long id;

    @Column
    private String location;

    @Builder
    public LocationEntity(Long id, String location){
        this.id =id;
        this.location =location;
    }
}
