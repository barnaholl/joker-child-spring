package com.codecool.jokerchildspring.repository;

import com.codecool.jokerchildspring.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School,Long> {
    List<School> findAllByTeacherId(Long teacherId);
    List<School> findAllByName(String name);
}
