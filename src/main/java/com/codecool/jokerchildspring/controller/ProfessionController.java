package com.codecool.jokerchildspring.controller;

import com.codecool.jokerchildspring.entity.Profession;
import com.codecool.jokerchildspring.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/profession")
@RequiredArgsConstructor
public class ProfessionController {

    private final ProfessionService professionService;

    @GetMapping("/")
    public ResponseEntity getProfessionById(@RequestParam("id") Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(professionService.getProfessionById(id));
    }

    @GetMapping("/all")
    public ResponseEntity getAllProfessions(){
        return ResponseEntity.ok(professionService.getAllProfessions());
    }

    @PostMapping("/")
    public ResponseEntity createProfession(@RequestBody Profession profession){
        professionService.createProfession(profession);
        return ResponseEntity.ok("new profession created: "+profession);
    }

    @DeleteMapping("/")
    public ResponseEntity deleteProfession(@RequestParam("id") Long id){
        professionService.deleteProfession(id);
        return ResponseEntity.ok("Profession deleted with id: "+id);
    }

    @PutMapping("/")
    public ResponseEntity updateProfession(@RequestBody Profession profession){
        professionService.updateProfession(profession);
        return ResponseEntity.ok("Profession is updated to: "+ profession);
    }

}
