package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.Profession;
import com.codecool.jokerchildspring.repository.ProfessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionService {

    private final ProfessionRepository professionRepository;

    public Profession getProfessionById(Long id){
        return professionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Profession> getAllProfessions(){
        return professionRepository.findAll();
    }

    public void createProfession(Profession profession){
        Profession newProfession= Profession.builder().name(profession.getName()).picture(profession.getPicture()).build();
        professionRepository.save(newProfession);
    }

    public void deleteProfession(Long id){
        professionRepository.deleteById(id);
    }

    public void updateProfession(Profession profession){
        Profession oldProfession=professionRepository.findById(profession.getId()).orElseThrow(EntityNotFoundException::new);
        oldProfession.setName(profession.getName());
        oldProfession.setPicture(profession.getPicture());
        professionRepository.save(oldProfession);
    }


}
