package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.Card;
import com.codecool.jokerchildspring.entity.GameSession;
import com.codecool.jokerchildspring.repository.CardRepository;
import com.codecool.jokerchildspring.repository.GameSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLOutput;

@Service
@RequiredArgsConstructor
public class GameSessionService {

    private final GameSessionRepository gameSessionRepository;
    private final CardRepository cardRepository;

    public GameSession getGameSessionByUserId(Long userId) {
        System.out.println("getGameSessionByUserId:"+userId);
        return gameSessionRepository.findByUserId(userId).orElse(new GameSession());
    }

    public void createGameSession(GameSession gameSession) {
        GameSession oldGameSession=gameSessionRepository.getByUserId(gameSession.getUserId());
        System.out.println("createGameSession UserId"+gameSession.getUserId());
        if(oldGameSession!=null){
            System.out.println("Delete old gameSession");
            gameSessionRepository.delete(oldGameSession);
        }
        gameSessionRepository.save(gameSession);

    }

    public void deleteGameSessionByUserId(Long userId) {
        System.out.println("Delete gameSession UserId:"+userId);
        gameSessionRepository.deleteByUserId(userId);
    }

    public Card getGameSessionsCardByUserId(Long userId) {
        Long cardId=getGameSessionByUserId(userId).getCardId();
        System.out.println("UserID:"+userId+" CardID:"+cardId);
        return cardRepository.findById(cardId).orElseThrow(EntityNotFoundException::new);
    }

    public Boolean getIsGameSessionActive(Long userId) {
        System.out.println("getIsGameSessionActive:"+gameSessionRepository.findByUserId(userId).isPresent());
        return gameSessionRepository.findByUserId(userId).isPresent();
    }
}
