package com.codecool.jokerchildspring.controller;

import com.codecool.jokerchildspring.entity.GameHistory;
import com.codecool.jokerchildspring.service.GameHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/gameHistory")
@RequiredArgsConstructor
public class GameHistoryController {

    private final GameHistoryService gameHistoryService;

    @GetMapping("/")
    public ResponseEntity getGameHistoryById(@RequestParam("id") Long id){
        return ResponseEntity.ok(gameHistoryService.getGameHistoryById(id));
    }

    @GetMapping("/getXpByMember")
    public ResponseEntity getXpByMember(@RequestParam("memberId") Long memberId){
        return ResponseEntity.ok(gameHistoryService.getXpByMember(memberId));
    }

    @GetMapping("/all")
    public ResponseEntity getAllGameHistorys(){
        return ResponseEntity.ok(gameHistoryService.getAllGameHistorys());
    }

    @PostMapping("/")
    public ResponseEntity createGameHistory(@RequestBody GameHistory gameHistory){
        gameHistoryService.createGameHistory(gameHistory);
        return ResponseEntity.ok("GameHistory created"+gameHistory);
    }

    @PutMapping("/")
    public ResponseEntity updateGameHistory(@RequestBody GameHistory gameHistory){
        gameHistoryService.updateGameHistory(gameHistory);
        return ResponseEntity.ok("GameHistory updated to:"+gameHistory);
    }

    @DeleteMapping("/")
    public ResponseEntity deleteGameHistory(@RequestParam("id") Long id){
        gameHistoryService.deleteGameHistory(id);
        return ResponseEntity.ok("GameHistory deleted with id: "+ id);
    }
}
