package com.devsuerior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuerior.dsmovie.entities.Score;
import com.devsuerior.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

	
}
