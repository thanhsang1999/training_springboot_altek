package com.example.managerstudent.mapper.impl;

import com.example.managerstudent.dto.StudentDTO;
import com.example.managerstudent.entities.StudentEntity;
import com.example.managerstudent.mapper.IStudentMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;


@Component
public class StudentMapper implements IStudentMapper<StudentDTO, StudentEntity> {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    @Qualifier("dateTimeFormatterVN")
    DateTimeFormatter dtf;

    @Override
    public StudentDTO convertToDTO(StudentEntity entity) {
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setMssv(entity.getMssv());
        dto.setBirthday(entity.getBirthday().toString());
        String[] fullNameArr = entity.getFullName().split(" ");
        dto.setFirstName(fullNameArr[fullNameArr.length-1]);
        StringBuffer sb = new StringBuffer();
        String lastName = Arrays.stream(fullNameArr).limit(fullNameArr.length-1).collect(Collectors.joining(" "));
        dto.setLastName(lastName);
        dto.setBirthday(entity.getBirthday().format(dtf));
        return dto;
    }

    @Override
    public StudentEntity convertToEntity(StudentDTO dto) {
        StudentEntity entity = new StudentEntity();
        entity.setId(dto.getId());
        entity.setFullName(dto.getLastName()+" "+dto.getFirstName());
        entity.setMssv(dto.getMssv());
        LocalDateTime ld = LocalDateTime.parse(dto.getBirthday(),dtf);
        entity.setBirthday(ld);
        return entity;
    }
}
