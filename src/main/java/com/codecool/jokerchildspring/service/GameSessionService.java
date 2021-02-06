package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.GameSession;
import com.codecool.jokerchildspring.repository.GameSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class GameSessionService {

    private GameSessionRepository gameSessionRepository;

    public GameSession getGameSessionByUserId(Long userId) {
        return gameSessionRepository.findByUserId(userId).orElseThrow(EntityNotFoundException::new);
    }

    public void createGameSession(GameSession gameSession) {
        gameSessionRepository.save(gameSession);
    }

    public void deleteGameSessionByUserId(Long userId) {
        gameSessionRepository.deleteByUserId(userId);
    }
}
