package com.codecool.jokerchildspring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class JoinRequest {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private Long schoolId;
}
