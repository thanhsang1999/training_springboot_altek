package com.example.managerstudent.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "map_data")
public class MapDataEntity {
    @Id
    private String name;
    @Column
    private String value;
}
