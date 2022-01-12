package com.devsuerior.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuerior.dsmovie.dto.MovieDTO;
import com.devsuerior.dsmovie.dto.ScoreDTO;
import com.devsuerior.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value ="/scores")
public class ScoreController {
	
	
	
	// Parâmeto de URL no Spring PutMapping irá manter o e-mail do usuário já cadastrado
	@Autowired
	private ScoreService  service;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
		MovieDTO movieDTO = service.saveScore(dto);
		return movieDTO;
	}
}
