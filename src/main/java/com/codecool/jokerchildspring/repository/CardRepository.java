package com.codecool.jokerchildspring.repository;

import com.codecool.jokerchildspring.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}
