package com.codecool.jokerchildspring.repository;

import com.codecool.jokerchildspring.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
