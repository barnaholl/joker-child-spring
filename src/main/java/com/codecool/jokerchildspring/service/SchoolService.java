package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.School;
import com.codecool.jokerchildspring.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

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

    public Set<String> getSchoolNames() {
        Set<String> allSchoolName = schoolRepository.findAll().stream().map(School::getName).collect(Collectors.toCollection(TreeSet::new));
        return allSchoolName;
    }

    public List<School> getClassesBySchool(String name){
        return schoolRepository.findAllByName(name);
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
