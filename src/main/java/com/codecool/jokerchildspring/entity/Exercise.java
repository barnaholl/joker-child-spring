package com.codecool.jokerchildspring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    //@ToString.Exclude
    //@EqualsAndHashCode.Exclude
    @Singular
    @JsonBackReference
    @OneToMany(mappedBy = "exercise",cascade = {CascadeType.PERSIST})
    private List<Answer> answers;

    private String assistance;

}
