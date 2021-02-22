package com.codecool.jokerchildspring.controller;

import com.codecool.jokerchildspring.entity.Card;
import com.codecool.jokerchildspring.entity.GameSession;
import com.codecool.jokerchildspring.service.GameSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/gameSession")
@RequiredArgsConstructor
public class GameSessionController {

    private final GameSessionService gameSessionService;

    @GetMapping("/")
    public ResponseEntity<GameSession> getGameSessionByUserId(@RequestParam("userId") Long userId){
        return ResponseEntity.ok(gameSessionService.getGameSessionByUserId(userId));
    }

    @PostMapping("/")
    public ResponseEntity<String> createGameSession(@RequestBody GameSession gameSession){
        gameSessionService.createGameSession(gameSession);
        return ResponseEntity.ok("Game session created: "+ gameSession);
    }

    @Transactional
    @DeleteMapping("/")
    public ResponseEntity<String> deleteGameSessionByUserId(@RequestParam("userId") Long userId){
        gameSessionService.deleteGameSessionByUserId(userId);
        return ResponseEntity.ok("Game session deleted with userId: "+userId);
    }

    @GetMapping("/card/")
    public ResponseEntity<Card> getGameSessionsCardByUserId(@RequestParam("userId") Long userId){
        return ResponseEntity.ok(gameSessionService.getGameSessionsCardByUserId(userId));
    }

    @GetMapping("/isActive")
    public ResponseEntity<Boolean> getIsGameSessionActive(@RequestParam("userId") Long userId){
        return ResponseEntity.ok(gameSessionService.getIsGameSessionActive(userId));
    }

}
