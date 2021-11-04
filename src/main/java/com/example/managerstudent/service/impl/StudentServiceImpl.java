package com.example.managerstudent.service.impl;

import com.example.managerstudent.dto.StudentDTO;
import com.example.managerstudent.entities.StudentEntity;
import com.example.managerstudent.mapper.IStudentMapper;
import com.example.managerstudent.repository.IStudentReponsitory;
import com.example.managerstudent.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    IStudentReponsitory studentReponsitory;
    @Autowired
    IStudentMapper<StudentDTO,StudentEntity> studentMapper;

    @Override
    public List<StudentDTO> getListStudents(Integer page, Integer size) {
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<StudentEntity> studentEntities = studentReponsitory.findAll(pageable);
        List<StudentEntity> students = studentEntities.getContent();
        List<StudentDTO> listStudentDTO = students.stream().map(e->studentMapper.convertToDTO(e)).collect(Collectors.toList());
        return listStudentDTO;
    }
    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO){

            StudentEntity studentEntity = studentMapper.convertToEntity(studentDTO);
        if (studentDTO.getId()==null){
            studentReponsitory.save(studentEntity);
        }else {
            Optional<StudentEntity> studentEntityOptional = studentReponsitory.findById(studentDTO.getId());
            if(studentEntityOptional.isPresent()){
            studentReponsitory.save(studentEntity);
            }
        }
        return studentDTO;
    }

}
