package com.codecool.jokerchildspring.repository;

import com.codecool.jokerchildspring.entity.GameHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameHistoryRepository extends JpaRepository<GameHistory,Long> {
    Optional<GameHistory> findByMemberId(Long memberId);

    Optional<GameHistory> findByExerciseIdAndMemberId(Long exerciseId, Long userId);

    Optional<GameHistory> findById(Long id);

    Optional<GameHistory> findByMemberIdAndExerciseId(Long memberId, Long exerciseId);

    List<GameHistory> findAllByMemberId(Long memberId);

    List<GameHistory> findByMemberIdAndCardId(Long memberId, Long cardId);
}