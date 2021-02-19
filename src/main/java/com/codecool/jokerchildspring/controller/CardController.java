package com.codecool.jokerchildspring.controller;

import com.codecool.jokerchildspring.entity.Card;
import com.codecool.jokerchildspring.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/")
    public ResponseEntity getCardById(@RequestParam("id") Long id){
        return ResponseEntity.ok(cardService.getCardById(id));
    }

    @GetMapping("/byIdentificationId")
    public ResponseEntity getCardByIdentificationId(@RequestParam("identificationId") String identificationId){
        return ResponseEntity.ok(cardService.getCardByIdentificationId(identificationId));
    }

    @GetMapping("/all")
    public ResponseEntity getAllCards(){
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @PostMapping("/")
    public ResponseEntity createCard(@RequestBody  Card card){
        cardService.createCard(card);
        return ResponseEntity.ok("Card created"+card);
    }

    @PostMapping("/withProfession")
    public ResponseEntity createCardWithExistingProfession(@RequestParam("professionId") Long professionId,@RequestBody  Card card){
        cardService.createCardWithExistingProfession(card,professionId);
        return ResponseEntity.ok("Card created"+card+" with professionId:"+professionId);
    }

    @PutMapping("/withProfession")
    public ResponseEntity updateCardWithExistingProfession(@RequestParam("professionId") Long professionId,@RequestBody  Card card){
        cardService.updateCardWithExistingProfession(card,professionId);
        return ResponseEntity.ok("Card updated"+card+" with professionId:"+professionId);
    }

    @PutMapping("/")
    public ResponseEntity updateCard(@RequestBody Card card){
        cardService.updateCard(card);
        return ResponseEntity.ok("Card updated to:"+card);
    }

    @DeleteMapping("/")
    public ResponseEntity deleteCard(@RequestParam("id") Long id){
        cardService.deleteCard(id);
        return ResponseEntity.ok("Card deleted with id: "+ id);
    }
}
