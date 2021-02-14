package com.codecool.jokerchildspring.entity;

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

    private Long memberId;

    private Long cardId;

    private Long exerciseId;

    private Boolean passed=false;

    @Column(columnDefinition = "integer default 0")
    private int badCount;

    private Date passedDate;

    @Column(columnDefinition = "integer default 0")
    private int experience;

}
