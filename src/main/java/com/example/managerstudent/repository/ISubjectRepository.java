package com.example.managerstudent.repository;

import com.example.managerstudent.dto.StudentDTO;
import com.example.managerstudent.entities.StudentEntity;
import com.example.managerstudent.entities.SubjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ISubjectRepository extends JpaRepository<SubjectEntity, Long> {
        List<SubjectEntity> findAll();
        Optional<SubjectEntity> findById(Long id);
        SubjectEntity save(SubjectEntity entity);
        SubjectEntity findByName(String name);
        List<SubjectEntity> findAllByIdStudent(Long idStudent);
        void deleteById(Long id);


}
