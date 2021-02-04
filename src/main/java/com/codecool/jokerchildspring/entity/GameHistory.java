package com.codecool.jokerchildspring.entity;

import com.codecool.jokerchildspring.model.MemberRole;
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

    @JsonManagedReference
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Member member;

    @JsonManagedReference
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Card card;

    @JsonManagedReference
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Exercise exercise;

    private Boolean passed=false;

    private int badCount=0;

    private Date passedDate;

    private int experience=0;

}
