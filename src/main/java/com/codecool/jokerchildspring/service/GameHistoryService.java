package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.GameHistory;
import com.codecool.jokerchildspring.repository.GameHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameHistoryService {

    private final GameHistoryRepository gameHistoryRepository;

    public GameHistory getGameHistoryById(Long id) {
        return gameHistoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public int getXpByMember(Long memberId){
        GameHistory gh = gameHistoryRepository.findByMemberId(memberId).orElseThrow(EntityNotFoundException::new);
        return gh.getExperience();
    }

    public List<GameHistory> getAllGameHistorys() {
        return gameHistoryRepository.findAll();
    }

    public void createGameHistory(GameHistory gameHistory) {
        //TODO:RoleCheck
        gameHistoryRepository.save(gameHistory);
    }

    public void updateGameHistory(GameHistory gameHistory) {
        //TODO:RoleCheck
        GameHistory oldGameHistory= gameHistoryRepository.findById(gameHistory.getId()).orElseThrow(EntityNotFoundException::new);
        oldGameHistory.setMemberId(gameHistory.getMemberId());
        oldGameHistory.setCard(gameHistory.getCard());
        oldGameHistory.setExercise(gameHistory.getExercise());
        oldGameHistory.setPassed(gameHistory.getPassed());
        oldGameHistory.setBadCount(gameHistory.getBadCount());
        oldGameHistory.setPassedDate(gameHistory.getPassedDate());
        oldGameHistory.setExperience(gameHistory.getExperience());
        gameHistoryRepository.save(oldGameHistory);
    }

    public void deleteGameHistory(Long id) {
        gameHistoryRepository.deleteById(id);
    }
}