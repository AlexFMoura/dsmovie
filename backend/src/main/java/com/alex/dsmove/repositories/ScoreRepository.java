package com.alex.dsmove.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.dsmove.entities.Score;
import com.alex.dsmove.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
