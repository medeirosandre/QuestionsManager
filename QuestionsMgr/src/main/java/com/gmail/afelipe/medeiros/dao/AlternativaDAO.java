package com.gmail.afelipe.medeiros.dao;

import java.util.List;

import com.gmail.afelipe.medeiros.modelo.Alternativa;

public interface AlternativaDAO {

	public Alternativa adicionarAlternativa(Alternativa alternativa);
	public List<Alternativa> listarAlternativas();
	public void excluirAlternativa(Alternativa alternativa);
	
}
