package com.codecool.jokerchildspring.repository;

import com.codecool.jokerchildspring.entity.GameHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameHistoryRepository extends JpaRepository<GameHistory,Long> {
}
