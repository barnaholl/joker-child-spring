package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.Answer;
import com.codecool.jokerchildspring.entity.Card;
import com.codecool.jokerchildspring.entity.Exercise;
import com.codecool.jokerchildspring.entity.Profession;
import com.codecool.jokerchildspring.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataInitService implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Override
    public void run(String... args) throws Exception {
        Profession profession= Profession.builder().name("Programmer").picture("not yet").build();

        List<Answer> answerList= new ArrayList<>();
        answerList.add(Answer.builder().word("answer1").isTrue(true).build());
        answerList.add(Answer.builder().word("answer2").isTrue(false).build());
        answerList.add(Answer.builder().word("answer3").isTrue(false).build());
        answerList.add(Answer.builder().word("answer4").isTrue(true).build());

        Exercise exercise= Exercise.builder().question("Test question").assistance("test video url").answers(answerList).build();

        Card card= Card.builder().identificationId("1001").profession(profession).exercise(exercise).build();
        cardRepository.save(card);
    }
}
