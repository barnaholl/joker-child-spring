package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.*;
import com.codecool.jokerchildspring.model.MemberRole;
import com.codecool.jokerchildspring.repository.CardRepository;
import com.codecool.jokerchildspring.repository.MemberRepository;
import com.codecool.jokerchildspring.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public void run(String... args) throws Exception {
        Profession profession= Profession.builder().name("Programmer").picture("not yet").build();

        Exercise exercise= Exercise.builder().question("Test question").assistance("test video url").answer("answer1,answer2;answer3,answer4").build();

        Card card= Card.builder().identificationId("1003").profession(profession).exercise(exercise).build();
        cardRepository.save(card);

        Member student= Member.builder()
                .name("Dummy Student")
                .nick("BestStudentEver")
                .birthDate(Date.valueOf("1996-09-09"))
                .email("best@student.com")
                .password("1234")
                .role(MemberRole.STUDENT)
                .experience(0)
                .build();

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
        memberRepository.save(student);

        School school= School.builder()
                .city("Budapest")
                .name("Average School")
                .team("1a")
                .teacherId(2L)
                .student(1L)
                .build();

        schoolRepository.save(school);
    }
}
