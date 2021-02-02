package com.codecool.jokerchildspring.controller;

import com.codecool.jokerchildspring.entity.DummyEntity;
import com.codecool.jokerchildspring.repository.DummyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DummyController {

    @Autowired
    private DummyRepository dummyRepository;

    @GetMapping("/")
    public List<DummyEntity> getDummyEntities(){
        return dummyRepository.findAll();
    }

    @GetMapping("/post")
    public ResponseEntity postDummy(@RequestParam("text") String text){
        dummyRepository.save(DummyEntity.builder().text(text).build());
        return ResponseEntity.ok(text);
    }
}
