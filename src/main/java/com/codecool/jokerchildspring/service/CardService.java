package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.Card;
import com.codecool.jokerchildspring.entity.Profession;
import com.codecool.jokerchildspring.repository.CardRepository;
import com.codecool.jokerchildspring.repository.ProfessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final ProfessionRepository professionRepository;

    public Card getCardById(Long id) {
        return cardRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public void createCard(Card card) {
        cardRepository.save(card);
    }

    public void createCardWithExistingProfession(Card card,Long professionId) {
        Profession profession=professionRepository.findById(professionId).orElseThrow(EntityNotFoundException::new);

        card.setProfession(profession);
        cardRepository.save(card);

    }

    public void updateCard(Card card) {
        Card oldCard=cardRepository.findById(card.getId()).orElseThrow(EntityNotFoundException::new);
        oldCard.setIdentificationId(card.getIdentificationId());
        oldCard.setProfession(card.getProfession());
        oldCard.setExercises(card.getExercises());
        cardRepository.save(oldCard);
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    public Card getCardByIdentificationId(String identificationId) {
        return cardRepository.findByIdentificationId(identificationId);
    }
}
