package com.codecool.jokerchildspring.repository;

import com.codecool.jokerchildspring.entity.DummyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DummyRepository extends JpaRepository<DummyEntity,Long> {

}
