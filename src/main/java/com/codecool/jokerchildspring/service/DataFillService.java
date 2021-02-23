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
public class DataFillService {

    private final CardRepository cardRepository;
    private final SchoolRepository schoolRepository;
    private final MemberRepository memberRepository;
    private final ProfessionRepository professionRepository;
    private final GameHistoryRepository gameHistoryRepository;
    private final ExerciseRepository exerciseRepository;


    public void fill() throws Exception {

        cardRepository.deleteAll();
        schoolRepository.deleteAll();
        memberRepository.deleteAll();
        professionRepository.deleteAll();
        gameHistoryRepository.deleteAll();
        exerciseRepository.deleteAll();



        Profession profession1= Profession.builder().name("Űrhajós").description("Űrhajóval megy az ürbe és ott feladatokat lát el").build();
        professionRepository.save(profession1);


        Exercise exercise1= Exercise.builder()
                .question("Miért látjuk úgy a Földről, hogy változik a Hold alakja?")
                .assistance("https://www.youtube.com/watch?v=FDXPH8r0p30")
                .answer("Nap máshonnan süti,Nap sütötte rész fényes;mert lapos,könnyű porból van,gravitáció változik,apály-dagály mozgatja").build();
        Exercise exercise2= Exercise.builder()
                .question("Miért nem lehet kimenni az űrbe űrruha nélkül?")
                .assistance("https://www.youtube.com/watch?v=AsWDKqnihjo")
                .answer("túl hideg van,nincs levegő,nincs nyomás,túl meleg van;nem divatos,meteoritok miatt,kórokozók ellen,űrszmog miatt,megvéd űrlényektől,megszólnának a marslakók").build();
        Exercise exercise3= Exercise.builder()
                .question("Hogyan alakultak ki a Hold kráterei?")
                .assistance("https://www.youtube.com/watch?v=nJGHKCbg-fw")
                .answer("meteoritok bombázták, nincs légkör ami elfújja,nincs légkör ami megvédje;így született,idegenek ásták,űrharc maradványai,Nap olvasztotta meg").build();

        exerciseRepository.save(exercise1);
        exerciseRepository.save(exercise2);
        exerciseRepository.save(exercise3);

        List<Exercise> exercises1 = new ArrayList<>();
        exercises1.add(exercise1);
        exercises1.add(exercise2);
        exercises1.add(exercise3);




        Card card1= Card.builder()
                .id(1L)
                .identificationId("18hg4e1")
                .profession(profession1)
                .exercises(exercises1)
                .build();

        cardRepository.save(card1);







      
        Profession profession2= Profession.builder().name("Sportoló").description("Hivatásos sportoló. Az a feladata, hogy minél jobb sporteredményeket érjen el a szakágában.").build();
        professionRepository.save(profession2);


        Exercise exercise5= Exercise.builder()
                .question("Mi a szerepe az izzadásnak?")
                .assistance("test video url")
                .answer("Hűti a testet;Stresszoldó hatás,Nincs szerepe,Lemossa a koszt a bőrről").build();

        Exercise exercise6= Exercise.builder()
                .question("Meddig bírja az ember víz alatt egy levegővel?")
                .assistance("https://www.youtube.com/watch?v=L89kY5ewgqU")
                .answer("Átlag ember 30-90 másodperc,Világrekord 24 perc;Nincs levegő így nem bírja,Pár óra,Az első 5 perc nehéz csak").build();
        Exercise exercise7= Exercise.builder()
                .question("Milyen vitaminokat fogyassz izomlázra?")
                .assistance("https://www.youtube.com/watch?v=56r7tuql3FM")
                .answer("Kálcium,Magnézium,Banán;C vitamin,Fanta,Pókagya-macskahája,Tejszínes jég").build();


        exerciseRepository.save(exercise5);
        exerciseRepository.save(exercise6);
        exerciseRepository.save(exercise7);

        List<Exercise> exercises2 = new ArrayList<>();
        exercises2.add(exercise5);
        exercises2.add(exercise6);
        exercises2.add(exercise7);



        Card card2= Card.builder()
                .id(2L)
                .identificationId("987ki54la")
                .profession(profession2)
                .exercises(exercises2)
                .build();

        cardRepository.save(card2);


        Member student= Member.builder()
                .id(0L)
                .name("Viktória")
                .nick("Vikusz")
                .birthDate(Date.valueOf("2009-09-09"))
                .email("best@student.com")
                .password("1234")
                .role(MemberRole.STUDENT)
                .experience(0)
                .build();

        memberRepository.save(student);

        /*Member teacher= Member.builder()
                .id(1L)
                .name("Dummy Teacher")
                .nick("BestTeacherEver")
                .birthDate(Date.valueOf("1996-09-09"))
                .email("best@teacher.com")
                .password("1234")
                .role(MemberRole.TEACHER)
                .experience(2)
                .build();

        memberRepository.save(teacher);
        */


        School school= School.builder()
                .city("Budapest")
                .name("Average School")
                .team("5a")
                .teacherId(2L)
                .build();

        schoolRepository.save(school);




    }
}