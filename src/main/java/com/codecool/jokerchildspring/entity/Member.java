package com.codecool.jokerchildspring.entity;

import com.codecool.jokerchildspring.model.MemberRole;
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

    private String username;

    private String email;

    private String password;

    private Date birthDate;

    private MemberRole role;

    private Integer experience;

}
