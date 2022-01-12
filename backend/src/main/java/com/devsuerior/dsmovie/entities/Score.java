package com.devsuerior.dsmovie.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")

public class Score implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// para garantir que o objeto esteja instanciado
	// devemos incluir o new ScorePK
	
	@EmbeddedId
	private ScorePK id = new ScorePK();
	private Double value;
	
	public Score() {
		
	}
	
	// Metodo para informar um  filme e associar ao Score
	// o id é do tipo scorePK e o ScorePK tem a referencia do movie
	
	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}
	
	// Metodo para informar um  usuário e associar ao Score
	// o id é do tipo scorePK e o ScorePK tem a referencia do user.
	
	public void setUser(User user) {
		id.setUser(user);
	}
	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
}
