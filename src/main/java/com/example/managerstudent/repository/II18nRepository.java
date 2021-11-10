package com.example.managerstudent.repository;

import com.example.managerstudent.entities.I18nEntity;
import com.example.managerstudent.entities.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface II18nRepository extends JpaRepository<I18nEntity, Long> {
}
