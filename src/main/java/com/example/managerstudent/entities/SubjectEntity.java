package com.example.managerstudent.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subject")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SubjectEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private Long idStudent;

}
