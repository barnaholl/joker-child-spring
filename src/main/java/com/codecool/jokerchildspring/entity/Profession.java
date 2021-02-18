package com.codecool.jokerchildspring.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Profession {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String picture;

    private String description;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany()
    private List<Card> card;

}
