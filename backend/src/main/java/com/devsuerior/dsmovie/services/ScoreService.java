package com.devsuerior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuerior.dsmovie.dto.MovieDTO;
import com.devsuerior.dsmovie.dto.ScoreDTO;
import com.devsuerior.dsmovie.entities.Movie;
import com.devsuerior.dsmovie.entities.Score;
import com.devsuerior.dsmovie.entities.User;
import com.devsuerior.dsmovie.repositories.MovieRepository;
import com.devsuerior.dsmovie.repositories.ScoreRepository;
import com.devsuerior.dsmovie.repositories.UserRepository;

@Service

public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	// para garantir a transação com o banco de dados
	@Transactional

	// méto para salvar um novo score
	public MovieDTO saveScore(ScoreDTO dto) {

		// recuperando o usuário por e-mail, caso não exista o usuário é incluído no
		// banco

		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}

		Movie movie = movieRepository.findById(dto.getMovieId()).get();

		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());

		// salvando no banco de dados
		score = scoreRepository.saveAndFlush(score);

		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}

		double avg = sum / movie.getScores().size();

		movie.setScore(avg);
		movie.setCount(movie.getScores().size());

		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}

}
