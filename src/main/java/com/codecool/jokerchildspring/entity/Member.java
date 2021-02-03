package com.codecool.jokerchildspring.entity;

import com.codecool.jokerchildspring.model.MemberRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String nick;

    private String email;

    private String password;

    private Date birthDate;

    private MemberRole role;

//    @JsonManagedReference
//    @OneToOne(cascade = {CascadeType.PERSIST})
    //TO DO GameHistory type
    //private int gameHistory;

    private Integer experience;

    @JsonBackReference
    @Singular
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<School> heldClasses;

    @JsonBackReference
    @Singular
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<School> enrolledClasses;

}
