package com.codecool.jokerchildspring.controller;

import com.codecool.jokerchildspring.entity.GameHistory;
import com.codecool.jokerchildspring.service.GameHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/gameHistory")
@RequiredArgsConstructor
public class GameHistoryController {

    private final GameHistoryService gameHistoryService;

    @GetMapping("/")
    public ResponseEntity<GameHistory> getGameHistoryById(@RequestParam("id") Long id){
        return ResponseEntity.ok(gameHistoryService.getGameHistoryById(id));
    }

    @GetMapping("/getPlayedExercisesCountByMemberId")
    public ResponseEntity<Integer> getPlayedCardsCountByMemberId(@RequestParam("memberId") Long memberId){
        return ResponseEntity.ok(gameHistoryService.getPlayedExercisesCountByMemberId(memberId));
    }

    @PutMapping("/validateExercise")
    public ResponseEntity<String> validateExercise(@RequestParam("memberId") Long memberId,@RequestParam("exerciseId") Long exerciseId,@RequestParam("passed") boolean passed){

        return ResponseEntity.ok(gameHistoryService.validateExercise(memberId,exerciseId,passed));
    }

    @GetMapping("/getSumXpByCardIdAndMemberId")
    public ResponseEntity<Integer> getSumXpByCardIdAndMemberId(@RequestParam("memberId") Long memberId,@RequestParam("cardId") Long cardId){
        return ResponseEntity.ok( gameHistoryService.getSumXpByMemberIdAndCardId(memberId,cardId) );
    }

    @GetMapping("/all")
    public ResponseEntity<List<GameHistory>> getAllGameHistories(){
        return ResponseEntity.ok(gameHistoryService.getAllGameHistories());
    }

    @PostMapping("/")
    public ResponseEntity<String> createGameHistory(@RequestBody GameHistory gameHistory){
        gameHistoryService.createGameHistory(gameHistory);
        return ResponseEntity.ok("GameHistory created "+gameHistory);
    }

    @PutMapping("/")
    public ResponseEntity<String> updateGameHistory(@RequestBody GameHistory gameHistory){
        gameHistoryService.updateGameHistory(gameHistory);
        return ResponseEntity.ok("GameHistory updated to:"+gameHistory);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteGameHistory(@RequestParam("id") Long id){
        gameHistoryService.deleteGameHistory(id);
        return ResponseEntity.ok("GameHistory deleted with id: "+ id);
    }

    @GetMapping("/getExperienceByExerciseIdAndMemberId")
    public ResponseEntity<Integer> getExperienceByExerciseIdAndMemberId(@RequestParam("exerciseId") Long exerciseId,@RequestParam("userId") Long userId){
        return ResponseEntity.ok(gameHistoryService.getExperienceByExerciseIdAndMemberId(exerciseId,userId));
    }

    @GetMapping("/getIsGameHistoryExistByExerciseIdAndUserId")
    public ResponseEntity<Boolean> getIsGameHistoryExistByExerciseIdAndUserId(@RequestParam("exerciseId") Long exerciseId,@RequestParam("userId") Long userId){
        return ResponseEntity.ok(gameHistoryService.getIsGameHistoryExistByExerciseIdAndUserId(exerciseId,userId));
    }

    @Transactional
    @DeleteMapping("/allGameHistoryByUserId")
    public ResponseEntity<String> deleteAllGameHistoryByUserId(@RequestParam("userId") Long userId){
        gameHistoryService.deleteAllGameHistoryByUserId(userId);
        return ResponseEntity.ok("game history cleared at userId: "+userId);
    }
}
