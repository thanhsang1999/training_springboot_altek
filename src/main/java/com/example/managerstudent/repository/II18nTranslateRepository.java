package com.example.managerstudent.repository;

import com.example.managerstudent.entities.I18nTranslateEntity;
import com.example.managerstudent.entities.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface II18nTranslateRepository extends JpaRepository<I18nTranslateEntity, Long> {
    String getByIdI18nAndLocate(Long idI18n,String locate);
}
