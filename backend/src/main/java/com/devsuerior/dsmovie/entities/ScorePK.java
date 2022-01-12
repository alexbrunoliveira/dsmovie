package com.devsuerior.dsmovie.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/* Classe auxiliar que tem as duas chaves estrangeiras, com 
id do movie e user. Sendo assim, uma chave primaria composta
*/

@Embeddable
public class ScorePK implements Serializable  {
		private static final long serialVersionUID = 1L;

	// Configurando para fazer referência ao modelo do DBA
	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name="user_id") 
	private User user;
 
	public ScorePK() {
		
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
