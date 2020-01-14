package com.gmail.afelipe.medeiros.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.gmail.afelipe.medeiros.dao.QuestaoDAO;
import com.gmail.afelipe.medeiros.dao.QuestaoDAOImpl;
import com.gmail.afelipe.medeiros.modelo.Alternativa;
import com.gmail.afelipe.medeiros.modelo.Questao;

@ManagedBean(name = "questaoBean")
@SessionScoped
public class QuestaoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Questao questao;
	private List<Questao> listaQuestoes;
	
	public Questao iniciarQuestao() {
		Questao q = new Questao();
		q.addAlternativa(new Alternativa());
		q.addAlternativa(new Alternativa());
		
		return q;
	}
	
	public String adicionarForm() {
		this.setQuestao(this.iniciarQuestao());
		return "/questao/inserir";
	}
	
	public String listarForm() {
		return "/questao/listar";
	}
	
	public String adicionarQuestao() {
		QuestaoDAO dao = new QuestaoDAOImpl();
		dao.adicionarQuestao(this.questao);
		
		this.displayMessage("Salvo com sucesso!");
		return this.adicionarForm();
	}
	
	public String excluirQuestao(Integer questaoId) {
		QuestaoDAO dao = new QuestaoDAOImpl();
		dao.excluirQuestao(dao.buscarQuestao(questaoId));
		
		this.displayMessage("Excluído com sucesso!");
		return this.listarForm();
	}
	
	public void displayMessage(String msg) {  
		FacesContext context = FacesContext.getCurrentInstance();  
		context.addMessage(null, new FacesMessage(msg));  
	} 
	
	public Questao getQuestao() {
		return questao;
	}
	
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	
	public List<Questao> getListaQuestoes() {
		QuestaoDAO dao = new QuestaoDAOImpl();
		return dao.buscarQuestoes();
	}

	public void setListaQuestoes(List<Questao> listaQuestoes) {
		this.listaQuestoes = listaQuestoes;
	}
	
	@PostConstruct
	public void init() {
		this.setQuestao(this.iniciarQuestao());
	}
	
}
