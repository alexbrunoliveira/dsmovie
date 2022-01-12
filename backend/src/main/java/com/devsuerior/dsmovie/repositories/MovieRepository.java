package com.devsuerior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuerior.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	
}
