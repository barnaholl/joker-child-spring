package com.codecool.jokerchildspring.entity;

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

    private String city;

    private String name;

    private String team;

    private Long teacherId;


}
