package com.gmail.afelipe.medeiros.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Alternativa extends BaseEntity implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 3242228692952999887L;
	
	@Column(nullable = false, length = 150)
	private String descricao;
	@Column(nullable = false)
	private boolean alternativaCorreta;
	
	public Alternativa() {}
	
	public Alternativa(String descricao, boolean alternativaCorreta) {
		this.setDescricao(descricao);
		this.setAlternativaCorreta(alternativaCorreta);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAlternativaCorreta() {
		return alternativaCorreta;
	}

	public void setAlternativaCorreta(boolean alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}
	
}
