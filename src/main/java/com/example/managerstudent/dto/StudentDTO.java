package com.example.managerstudent.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDTO {
    private Long id;
    private String nameVN;
    private String nameEN;
    private int mssv;
    private String birthday;
    private List<SubjectDTO> listSubject;
}
