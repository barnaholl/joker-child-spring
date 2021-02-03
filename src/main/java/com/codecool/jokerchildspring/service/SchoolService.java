package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.School;
import com.codecool.jokerchildspring.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public School getSchoolById(Long id) {
        return schoolRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public void createSchool(School school) {
        schoolRepository.save(school);
    }

    public void updateSchool(School school) {
        School oldSchool= schoolRepository.findById(school.getId()).orElseThrow(EntityNotFoundException::new);
        oldSchool.setCity(school.getName());
        oldSchool.setName(school.getName());
        oldSchool.setTeam(school.getTeam());
        schoolRepository.save(oldSchool);
    }

    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }
}
