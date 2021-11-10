package com.example.managerstudent.service;

import com.example.managerstudent.dto.ListStudentWithPagi;
import com.example.managerstudent.dto.StudentDTO;

import java.util.List;

public interface IStudentService {


    ListStudentWithPagi getListStudents(Integer page, Integer size, String search, String columnOrder, String order);

    StudentDTO getStudentDTO(Long id);

    StudentDTO saveStudent(StudentDTO studentDTO);

    void deleteById(Long id);
}
