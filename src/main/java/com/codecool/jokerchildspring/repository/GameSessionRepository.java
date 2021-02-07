package com.codecool.jokerchildspring.repository;

import com.codecool.jokerchildspring.entity.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameSessionRepository extends JpaRepository<GameSession,Long> {
    Optional<GameSession> findByUserId(Long userId);

    void deleteByUserId(Long userId);

    GameSession getByUserId(Long userId);
}
