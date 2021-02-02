package com.codecool.jokerchildspring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Answer {

    @Id
    @GeneratedValue
    private Long id;

    //TODO:Limit
    private String word;

    private Boolean isTrue;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private Exercise exercise;

}
