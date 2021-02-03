package com.codecool.jokerchildspring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class School {

    @Id
    @GeneratedValue
    private Long id;

    private String city;

    private String name;

    private String team;

    private Long teacherId;

    @ElementCollection
    @Singular
    private List<Long> students;

}
