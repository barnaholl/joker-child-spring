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
public class Exercise {

    @Id
    @GeneratedValue
    private Long id;

    private String question;

    private String answer;

    @JsonBackReference
    @ManyToOne()
    private Card card;

    private String assistance;

    @JsonBackReference
    @OneToOne(cascade = {CascadeType.PERSIST})
    private GameHistory gameHistory;

}
