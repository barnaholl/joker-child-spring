package com.codecool.jokerchildspring.entity;

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
public class GameSession {
    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private Long cardId;
}
