package com.gmail.afelipe.medeiros.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Questao extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 150)
	private String descricao;
	
	@OneToMany(targetEntity = Alternativa.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Alternativa> alternativas;
	
	public Questao() {
		this.alternativas = new ArrayList<Alternativa>();
	}
	
	public Questao(String descricao) {
		this.setDescricao(descricao);
		this.alternativas = new ArrayList<Alternativa>();
	}
	
	public void addAlternativa(Alternativa alternativa) {
		this.alternativas.add(alternativa);
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Alternativa> getAlternativas() {
		return alternativas;
	}
	
}
