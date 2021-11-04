package com.example.managerstudent.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class SubjectDTO {
    private Long id;
    private String name;
    private Long idStudent;
}
