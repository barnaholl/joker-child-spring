package com.codecool.jokerchildspring.repository;

import com.codecool.jokerchildspring.entity.JoinRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoinRequestRepository extends JpaRepository<JoinRequest,Long> {
    List<JoinRequest> findAllBySchoolId(Long schoolId);
}
