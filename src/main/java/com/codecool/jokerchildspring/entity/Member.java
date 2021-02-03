package com.codecool.jokerchildspring.entity;

import com.codecool.jokerchildspring.model.MemberRole;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

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

}
