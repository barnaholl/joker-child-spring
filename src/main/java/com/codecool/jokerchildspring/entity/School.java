package com.codecool.jokerchildspring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

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
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Member member;

    private String city;

    private String name;

    private String team;   // class vagy group nem lehet

}