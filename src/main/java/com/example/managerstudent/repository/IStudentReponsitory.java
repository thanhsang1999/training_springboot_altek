package com.example.managerstudent.repository;

import com.example.managerstudent.dto.StudentDTO;
import com.example.managerstudent.entities.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IStudentReponsitory extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findById(Long id);
    StudentEntity save(StudentEntity student);
    StudentEntity findByFullName(String fullName);
    Page<StudentEntity> findAll(Pageable pageable);
}
