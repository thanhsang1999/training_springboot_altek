package com.example.managerstudent.service.impl;

import com.example.managerstudent.dto.StudentDTO;
import com.example.managerstudent.dto.SubjectDTO;
import com.example.managerstudent.entities.SubjectEntity;
import com.example.managerstudent.repository.ISubjectRepository;
import com.example.managerstudent.service.ISubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements ISubjectService {
    @Autowired
    ISubjectRepository subjectReponsitory;
    @Autowired
    ModelMapper mapper;

    @Override
    public List<SubjectDTO> findAll() {
        List<SubjectEntity> subjectEntities = subjectReponsitory.findAll();
        List<SubjectDTO> listSubjects = subjectEntities.stream()
                .map(e -> mapper.map(e, SubjectDTO.class))
                .collect(Collectors.toList());
        return listSubjects;
    }

    @Override
    public SubjectDTO findById(Long id) {
        Optional<SubjectEntity> subjectEntity = subjectReponsitory.findById(id);
        if (!subjectEntity.isPresent()) return null;
        return mapper.map(subjectEntity.get(), SubjectDTO.class);
    }

    @Override
    public SubjectDTO save(SubjectDTO dto) {
        SubjectEntity entity = mapper.map(dto, SubjectEntity.class);
        SubjectEntity subjectEntity = subjectReponsitory.save(entity);



        return  mapper.map(subjectEntity, SubjectDTO.class);
    }

    @Override
    public SubjectDTO findByName(String name) {
        SubjectEntity subjectEntity = subjectReponsitory.findByName(name);
        return  mapper.map(subjectEntity, SubjectDTO.class);
    }

    @Override
    public List<SubjectDTO> findAllByIdStudent(Long idStudent) {
        List<SubjectDTO> dto = null;
        List<SubjectEntity> subjectEntities = subjectReponsitory.findAllByIdStudent(idStudent);
        dto = subjectEntities.stream().map(e->mapper.map(e,SubjectDTO.class)).collect(Collectors.toList());
        return dto;
    }

    @Override
    public void deleteById(Long id) {
        subjectReponsitory.deleteById(id);
    }
}
