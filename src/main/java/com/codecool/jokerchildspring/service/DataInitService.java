package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.*;
import com.codecool.jokerchildspring.model.MemberRole;
import com.codecool.jokerchildspring.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataInitService implements CommandLineRunner {

    private final CardRepository cardRepository;
    private final SchoolRepository schoolRepository;
    private final MemberRepository memberRepository;
    private final ProfessionRepository professionRepository;
    private final GameHistoryRepository gameHistoryRepository;

    @Override
    public void run(String... args) throws Exception {

        cardRepository.deleteAll();
        schoolRepository.deleteAll();
        memberRepository.deleteAll();
        professionRepository.deleteAll();
        gameHistoryRepository.deleteAll();


        Profession profession= Profession.builder().name("Űrhajós").picture("not yet").build();

        Exercise exercise1= Exercise.builder()
                .question("Miért látjuk úgy a Földről, hogy változik a Hold alakja?")
                .assistance("test video url")
                .answer("Nap máshonnan süti,Nap sütötte rész fényes;mert lapos,könnyű porból van,gravitáció változik,apály-dagály mozgatja").build();
        Exercise exercise2= Exercise.builder()
                .question("Miért nem lehet kimenni az űrbe űrruha nélkül?")
                .assistance("test video url")
                .answer("túl hideg van,nincs levegő,nincs nyomás,túl meleg van;nem divatos,meteoritok miatt,kórokozók ellen,űrszmog miatt,megvéd űrlényektől,megszólnának a marslakók").build();
        Exercise exercise3= Exercise.builder()
                .question("Hogyan alakultak ki a Hold kráterei?")
                .assistance("test video url")
                .answer("meteoritok bombázták, nincs légkör ami elfújja,nincs légköt ami megvédje;így született,idegenek ásták,űrharc maradványai,Nap olvasztotta meg,").build();

        List<Exercise> exercises = new ArrayList<>();
        exercises.add(exercise1);
        exercises.add(exercise2);
        exercises.add(exercise3);



        GameHistory gameHistory= GameHistory.builder()
                .memberId(7L)
                .passed(false)
                .badCount(0)
                .experience(10)
               // .passedDate(new Date("2021-01-12"))
                .build();

        gameHistoryRepository.save(gameHistory);





        Card card= Card.builder()
                .identificationId("18hg4e1")
                .profession(profession)
                .exercises(exercises)
                .build();

        cardRepository.save(card);


        Member student= Member.builder()
                .name("Viktória")
                .nick("Vikusz")
                .birthDate(Date.valueOf("2009-09-09"))
                .email("best@student.com")
                .password("1234")
                .role(MemberRole.STUDENT)
                .experience(0)
                .build();

        memberRepository.save(student);

        Member teacher= Member.builder()
                .name("Dummy Teacher")
                .nick("BestTeacherEver")
                .birthDate(Date.valueOf("1996-09-09"))
                .email("best@teacher.com")
                .password("1234")
                .role(MemberRole.TEACHER)
                .experience(0)
                .build();

        memberRepository.save(teacher);

        School school= School.builder()
                .city("Budapest")
                .name("Average School")
                .team("5a")
                .teacherId(2L)
                .student(1L)
                .build();

        schoolRepository.save(school);




    }
}
