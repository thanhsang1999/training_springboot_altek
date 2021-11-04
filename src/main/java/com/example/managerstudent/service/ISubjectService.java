package com.example.managerstudent.service;

import com.example.managerstudent.dto.StudentDTO;
import com.example.managerstudent.dto.SubjectDTO;
import com.example.managerstudent.entities.SubjectEntity;

import java.util.List;

public interface ISubjectService {

    List<SubjectDTO> findAll();

    SubjectDTO findById(Long id);

    SubjectDTO save(SubjectDTO dto);

    SubjectDTO findByName(String name);
}
