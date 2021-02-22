package com.codecool.jokerchildspring.controller;

import com.codecool.jokerchildspring.entity.Card;
import com.codecool.jokerchildspring.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/")
    public ResponseEntity<Card> getCardById(@RequestParam("id") Long id){
        return ResponseEntity.ok(cardService.getCardById(id));
    }

    @GetMapping("/byIdentificationId")
    public ResponseEntity<Card> getCardByIdentificationId(@RequestParam("identificationId") String identificationId){
        return ResponseEntity.ok(cardService.getCardByIdentificationId(identificationId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Card>> getAllCards(){
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @PostMapping("/")
    public ResponseEntity<String> createCard(@RequestParam("professionId") Long professionId,@RequestBody  Card card){
        cardService.createCard(card,professionId);
        return ResponseEntity.ok("Card created"+card+" with professionId:"+professionId);
    }

    @PutMapping("/")
    public ResponseEntity<String> updateCard(@RequestParam("professionId") Long professionId,@RequestBody  Card card){
        cardService.updateCard(card,professionId);
        return ResponseEntity.ok("Card updated"+card+" with professionId:"+professionId);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteCard(@RequestParam("id") Long id){
        cardService.deleteCard(id);
        return ResponseEntity.ok("Card deleted with id: "+ id);
    }
}
