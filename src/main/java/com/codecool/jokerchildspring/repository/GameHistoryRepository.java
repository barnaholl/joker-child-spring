package com.codecool.jokerchildspring.repository;

import com.codecool.jokerchildspring.entity.GameHistory;
import com.codecool.jokerchildspring.entity.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameHistoryRepository extends JpaRepository<GameHistory,Long> {
    Optional<GameHistory> findByMemberId(Long memberId);
}
