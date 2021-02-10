package com.codecool.jokerchildspring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

    @JsonBackReference
    @OneToOne(mappedBy = "profession")
    private Card card;

}
