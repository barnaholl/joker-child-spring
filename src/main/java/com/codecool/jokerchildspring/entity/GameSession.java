package com.codecool.jokerchildspring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @ManyToOne()
    private Card card;
}
