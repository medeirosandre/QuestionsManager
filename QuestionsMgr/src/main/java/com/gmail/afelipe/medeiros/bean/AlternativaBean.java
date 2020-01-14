package com.gmail.afelipe.medeiros.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.gmail.afelipe.medeiros.dao.AlternativaDAO;
import com.gmail.afelipe.medeiros.dao.AlternativaDAOImpl;
import com.gmail.afelipe.medeiros.modelo.Alternativa;

@ManagedBean(name = "alternativaBean")
@SessionScoped
public class AlternativaBean {
	
	private Alternativa alternativa;
	private DataModel<Alternativa> listaAlternativas;
	private String msg;
	
	public String adicionarForm() {
		this.setAlternativa(new Alternativa());
		return "inserir_alternativa_form";
	}
	
	public String listarForm() {
		return "listar_alternativas";
	}
	
	public String adicionarAlternativa() {
		AlternativaDAO dao = new AlternativaDAOImpl();
		dao.adicionarAlternativa(this.alternativa);
		
		this.setMsg("Salvo com sucesso!");
		return this.adicionarAlternativa();
	}
	
	public String excluirAlternativa() {
		Alternativa al = (Alternativa)(listaAlternativas.getRowData());
		AlternativaDAO dao = new AlternativaDAOImpl();
		dao.excluirAlternativa(al);
		
		this.setMsg("Excluído com sucesso!");
		return this.listarForm();
	}
	
	public Alternativa getAlternativa() {
		return alternativa;
	}
	
	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}
	
	public DataModel<Alternativa> getListaAlternativas() {
		AlternativaDAO dao = new AlternativaDAOImpl();
		List<Alternativa> lista = dao.listarAlternativas();
		listaAlternativas= new ListDataModel<Alternativa>(lista);
		
		return listaAlternativas;
	}
	
	public void setListaAlternativas(DataModel<Alternativa> listaAlternativas) {
		this.listaAlternativas = listaAlternativas;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@PostConstruct
	public void init() {
		this.setAlternativa(new Alternativa());
	}
	
}
