package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.Card;
import com.codecool.jokerchildspring.entity.GameSession;
import com.codecool.jokerchildspring.repository.CardRepository;
import com.codecool.jokerchildspring.repository.GameSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class GameSessionService {

    private final GameSessionRepository gameSessionRepository;
    private final CardRepository cardRepository;

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

    public Card getGameSessionsCardByUserId(Long userId) {
        Long cardId=getGameSessionByUserId(userId).getCardId();
        return cardRepository.findById(cardId).orElseThrow(EntityNotFoundException::new);
    }
}
