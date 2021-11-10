package com.example.managerstudent.repository;

import com.example.managerstudent.entities.MapDataEntity;
import com.example.managerstudent.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IMapDataRepository extends JpaRepository<MapDataEntity, String> {
    @Query(value = "SELECT m.value FROM map_data m WHERE m.name = :name",nativeQuery = true)
    String getValueByName(@Param("name") String name);
    @Query(value = "SELECT e.`name` from map_data e WHERE e.`value` LIKE '%:name%'",nativeQuery = true)
    List<SubjectEntity> findNameByValue(String name);

}
