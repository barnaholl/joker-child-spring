package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.Card;
import com.codecool.jokerchildspring.entity.Exercise;
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
        deleteEmptyQuestion(card);
        cardRepository.save(card);
    }

    public void createCardWithExistingProfession(Card card,Long professionId) {
        Profession profession=professionRepository.findById(professionId).orElseThrow(EntityNotFoundException::new);
        card.setProfession(profession);
        deleteEmptyQuestion(card);
        cardRepository.save(card);

    }

    public void updateCard(Card card) {
        Card oldCard=cardRepository.findById(card.getId()).orElseThrow(EntityNotFoundException::new);
        oldCard.setIdentificationId(card.getIdentificationId());
        oldCard.setProfession(card.getProfession());
        oldCard.setExercises(card.getExercises());
        deleteEmptyQuestion(oldCard);
        cardRepository.save(oldCard);
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    public Card getCardByIdentificationId(String identificationId) {
        return cardRepository.findByIdentificationId(identificationId);
    }

    public void updateCardWithExistingProfession(Card card, Long professionId) {
        Card oldCard=cardRepository.findById(card.getId()).orElseThrow(EntityNotFoundException::new);
        Profession profession=professionRepository.findById(professionId).orElseThrow(EntityNotFoundException::new);

        List<Exercise> newExercises=card.getExercises();
        List<Exercise> oldExercises=oldCard.getExercises();

        deleteEmptyQuestion(card);
        for (int i = 0; i < newExercises.size(); i++) {
            oldExercises.get(i).setQuestion(newExercises.get(i).getQuestion());
            oldExercises.get(i).setAnswer(newExercises.get(i).getAnswer());
            oldExercises.get(i).setAssistance(newExercises.get(i).getAssistance());
        }

        oldCard.setProfession(profession);
        oldCard.setExercises(oldExercises);
        oldCard.setIdentificationId(card.getIdentificationId());

        cardRepository.save(oldCard);
    }

    private void deleteEmptyQuestion(Card card){
        List<Exercise> exercises = card.getExercises();
        for (int i = card.getExercises().size()-1; i >= 0; i--) {
            if (card.getExercises().get(i).getQuestion().equals("")) {
                card.getExercises().remove(i);
                System.out.println("Remove "+i+". question, because it was empty.");
            }
        }
    }

}
