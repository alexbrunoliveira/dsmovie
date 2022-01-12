package com.devsuerior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuerior.dsmovie.dto.MovieDTO;
import com.devsuerior.dsmovie.entities.Movie;
import com.devsuerior.dsmovie.repositories.MovieRepository;

@Service

public class MovieService {
	/*
	 * O framework já tem uma ferramenta para instanciar o objeto // É apenas
	 * necessário a declaração da composição do componenme e incluir o @Autowired
	 */

	@Autowired
	private MovieRepository repository;

	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {

		Page<Movie> result = repository.findAll(pageable);
		// Convertendo a pagina da entidade Movie para DTO
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		// Retornando a converção
		return page;
	}

	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie result = repository.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		return dto;
	}

}
