package com.example.managerstudent.service;

import com.example.managerstudent.dto.StudentDTO;
import com.example.managerstudent.entities.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    abstract List<StudentDTO> getListStudents(Integer page, Integer size);

    StudentDTO saveStudent(StudentDTO studentDTO);
}
