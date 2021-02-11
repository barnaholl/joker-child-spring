package com.codecool.jokerchildspring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class GameHistory {

    @Id
    @GeneratedValue
    private Long id;

//    @JsonBackReference
//    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Long memberId;

//    @JsonManagedReference
//    @OneToOne(cascade = {CascadeType.PERSIST})
//    private Card card;
    private Long cardId;

    //@JsonManagedReference
    //@OneToOne(cascade = {CascadeType.PERSIST})
    private Long exerciseId;

    private Boolean passed=false;

    private int badCount=0;

    private Date passedDate;

    private int experience=0;

}
