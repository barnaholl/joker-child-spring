package com.codecool.jokerchildspring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    private Date birthDay;

    private int role;

//    @JsonManagedReference
//    @OneToOne(cascade = {CascadeType.PERSIST})
    //TO DO GameHistory type
    private int gameHistory;

    int experience;

}
