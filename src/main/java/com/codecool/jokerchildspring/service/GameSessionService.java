package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.GameSession;
import com.codecool.jokerchildspring.repository.GameSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameSessionService {

    private final GameSessionRepository gameSessionRepository;

    public GameSession getGameSessionByUserId(Long userId) {
        return gameSessionRepository.findByUserId(userId).orElseThrow(EntityNotFoundException::new);
    }

    public void createGameSession(GameSession gameSession) {
        GameSession oldGameSession=gameSessionRepository.getByUserId(gameSession.getUserId());
        if(oldGameSession!=null){
            gameSessionRepository.delete(oldGameSession);
        }
        gameSessionRepository.save(gameSession);

    }

    public void deleteGameSessionByUserId(Long userId) {
        gameSessionRepository.deleteByUserId(userId);
    }
}
