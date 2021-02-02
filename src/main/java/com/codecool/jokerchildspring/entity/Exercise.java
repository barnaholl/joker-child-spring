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

    //@ToString.Exclude
    //@EqualsAndHashCode.Exclude
    @Singular
    @JsonManagedReference
    @OneToMany(mappedBy = "exercise",cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Answer> answers;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private Card card;

    private String assistance;

}
