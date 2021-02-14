package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.Card;
import com.codecool.jokerchildspring.entity.GameHistory;
import com.codecool.jokerchildspring.entity.Member;
import com.codecool.jokerchildspring.repository.GameHistoryRepository;
import com.codecool.jokerchildspring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameHistoryService {

    private final GameHistoryRepository gameHistoryRepository;
    private final MemberRepository memberRepository;

    public GameHistory getGameHistoryById(Long id) {
        return gameHistoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

//    public int getXpByMember(Long memberId){
//        GameHistory gh = gameHistoryRepository.findByMemberId(memberId).orElseThrow(EntityNotFoundException::new);
//        return gh.getExperience();
//    }

    public int getBadCountByMemberIdAndExerciseId(Long memberId, Long exerciseId){
        GameHistory gh = gameHistoryRepository.findByMemberIdAndExerciseId(memberId,exerciseId).orElseThrow(EntityNotFoundException::new);
        return gh.getBadCount();
    }

    public boolean getPassedByMemberIdAndExerciseId(Long memberId, Long exerciseId){
        GameHistory gh = gameHistoryRepository.findByMemberIdAndExerciseId(memberId,exerciseId).orElseThrow(EntityNotFoundException::new);
        return gh.getPassed();
    }

    public int getPlayedExercisesCountByMemberId(Long memberId) {
        return gameHistoryRepository.findAllByMemberId(memberId).size();
    }

//    public List<Card> getPlayedCardsByMember(Long memberId) {
//        List<Card> gh = gameHistoryRepository.findAllByMemberId(memberId).filter(ghbm -> ghbm.getPassed()).map(ghbm -> ghbm.getCard());
//        return gh;
//    }

    public List<GameHistory> getAllGameHistorys() {
        return gameHistoryRepository.findAll();
    }

    public int putValidExercise(Long memberId,Long exerciseId,boolean passed){
        GameHistory gameHistory = gameHistoryRepository.findByMemberIdAndExerciseId(memberId,exerciseId).orElseThrow(EntityNotFoundException::new);
        if(!gameHistory.getPassed()) {
            if (passed) {
                gameHistory.setPassed(true);
                gameHistory.setPassedDate(new Date(System.currentTimeMillis()));
                switch (gameHistory.getBadCount()) {
                    case 0:
                        gameHistory.setExperience(3);
                        break;
                    case 1:
                        gameHistory.setExperience(2);
                        break;
                    default:
                        gameHistory.setExperience(1);
                        break;
                }
                Member member = memberRepository.findById(memberId).orElseThrow(EntityNotFoundException::new);
                member.setExperience(member.getExperience() + gameHistory.getExperience());
                memberRepository.save(member);
            } else {
                gameHistory.setBadCount(gameHistory.getBadCount() + 1);
            }
            gameHistoryRepository.save(gameHistory);
        }
        return gameHistory.getExperience();
    }

    public int getSumXpByMemberIdAndCardId(Long memberId, Long cardId){
        return gameHistoryRepository.findByMemberIdAndCardId(memberId,cardId).stream().map(item -> item.getExperience()).reduce(0, Integer::sum);
    }

    public void createGameHistory(GameHistory gameHistory) {
        //TODO:RoleCheck
        gameHistoryRepository.save(gameHistory);
    }

    public void updateGameHistory(GameHistory gameHistory) {
        //TODO:RoleCheck
        GameHistory oldGameHistory= gameHistoryRepository.findById(gameHistory.getId()).orElseThrow(EntityNotFoundException::new);
        oldGameHistory.setMemberId(gameHistory.getMemberId());
        oldGameHistory.setCardId(gameHistory.getCardId());
        oldGameHistory.setExerciseId(gameHistory.getExerciseId());
        oldGameHistory.setPassed(gameHistory.getPassed());
        oldGameHistory.setBadCount(gameHistory.getBadCount());
        oldGameHistory.setPassedDate(gameHistory.getPassedDate());
        oldGameHistory.setExperience(gameHistory.getExperience());
        gameHistoryRepository.save(oldGameHistory);
    }

    public void deleteGameHistory(Long id) {
        gameHistoryRepository.deleteById(id);
    }

    public Long getExperienceByExerciseIdAndMemberId(Long exerciseId, Long userId) {
        return (long) gameHistoryRepository.findByExerciseIdAndMemberId(exerciseId, userId).orElse(GameHistory.builder().experience(0).build()).getExperience();
    }
}