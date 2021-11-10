package com.example.managerstudent.repository;

import com.example.managerstudent.dto.StudentDTO;
import com.example.managerstudent.entities.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IStudentRepository extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findById(Long id);
    StudentEntity save(StudentEntity student);
    Page<StudentEntity> findAll(Pageable pageable);
    Page<StudentEntity> findAllByName(String name,Pageable pageable);
    void deleteById(Long id);
}
