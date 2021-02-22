package com.codecool.jokerchildspring.controller;

import com.codecool.jokerchildspring.entity.School;
import com.codecool.jokerchildspring.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/")
    public ResponseEntity<School> getSchoolById(@RequestParam("id") Long id){
        return ResponseEntity.ok(schoolService.getSchoolById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<School>> getAllSchools(){
        return ResponseEntity.ok(schoolService.getAllSchools());
    }

    @PostMapping("/")
    public ResponseEntity<String> createSchool(@RequestBody School school){
        schoolService.createSchool(school);
        return ResponseEntity.ok("School created"+school);
    }

    @PutMapping("/")
    public ResponseEntity<String> updateSchool(@RequestBody School school){
        schoolService.updateSchool(school);
        return ResponseEntity.ok("School updated to:"+school);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteSchool(@RequestParam("id") Long id){
        schoolService.deleteSchool(id);
        return ResponseEntity.ok("School deleted with id: "+ id);
    }
}
