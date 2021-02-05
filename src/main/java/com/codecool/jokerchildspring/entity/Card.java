package com.codecool.jokerchildspring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String identificationId;

    @JsonManagedReference
    @Singular
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Exercise> exercises;

    @JsonManagedReference
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Profession profession;

    @JsonBackReference
    @OneToOne(cascade = {CascadeType.PERSIST})
    private GameHistory gameHistory;

}
