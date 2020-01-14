package com.gmail.afelipe.medeiros.dao;

import java.util.List;

import com.gmail.afelipe.medeiros.modelo.Questao;

public interface QuestaoDAO {

	public Questao adicionarQuestao(Questao questao);
	public Questao atualizarQuestao(Questao questao);
	public Questao buscarQuestao(Integer id);
	public List<Questao> buscarQuestoes();
	public List<Questao> buscarQuestoes(int maxResultados, int primeiroResultado);
	public List<Questao> buscarQuestoes(boolean todos, int maxResultados, int primeiroResultado);
	public void excluirQuestao(Questao questao);
	
}
