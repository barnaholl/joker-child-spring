package com.codecool.jokerchildspring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Exercise {

    @Id
    @GeneratedValue
    private Long id;

    private String question;

    private String answer;

    @JsonBackReference
    @ToString.Exclude
    @ManyToOne()
    private Card card;

    private String assistance;


}
