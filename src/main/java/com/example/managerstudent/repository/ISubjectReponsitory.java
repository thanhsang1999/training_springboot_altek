package com.example.managerstudent.repository;

import com.example.managerstudent.dto.StudentDTO;
import com.example.managerstudent.entities.StudentEntity;
import com.example.managerstudent.entities.SubjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ISubjectReponsitory extends JpaRepository<SubjectEntity, Long> {
        List<SubjectEntity> findAll();
        Optional<SubjectEntity> findById(Long id);
        SubjectEntity save(SubjectEntity entity);
        SubjectEntity findByName(String name);

}
