package com.codecool.jokerchildspring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class School {

    @Id
    @GeneratedValue
    private Long id;

    @JsonManagedReference
    @Singular
    @ManyToMany()
    private List<Member> students;

    private String city;

    private String name;

    private String team;   // class vagy group nem lehet

    @JsonManagedReference
    @ManyToOne()
    private Member teacher;
}