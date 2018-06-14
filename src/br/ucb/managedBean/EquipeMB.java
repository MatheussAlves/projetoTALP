package br.ucb.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import br.ucb.dao.EquipeDAO;
import br.ucb.modelo.Equipe;
import br.ucb.modelo.Jogador;
import br.ucb.util.JSFMensageiro;
@ManagedBean(name="equipeMB")
@SessionScoped
public class EquipeMB implements Serializable{
	private static final long serialVersionUID = 1L;
	private EquipeDAO eDAO;
	private Equipe equipe;
	private List<Equipe> equipes;
	private List<Jogador> jogadores;
	
	public EquipeMB(){
		this.eDAO = new EquipeDAO();
		this.equipe = new Equipe();
		this.equipes = null;
		this.jogadores = null;
	}

	
	
	
	public String listar() {
		this.equipes = this.eDAO.listar();
		return "/entidades/equipeLista";
	}

	public String incluir() {
		this.equipe = new Equipe();
		return "/entidades/equipeForm";
	}

	public String salvar() {
		if (this.equipe.getId() == 0) {
			if (this.eDAO.incluir(this.equipe))
				JSFMensageiro.info("Equipe incluida com sucesso");
			else
				JSFMensageiro.error("Erro ao incluir a equipe!");
		}
		else {
			if (this.eDAO.alterar(this.equipe))
				JSFMensageiro.info("Equipe alterado com sucesso!");
			else
				JSFMensageiro.error("Erro ao alterar a equipe!");
		}
		this.equipe = new Equipe();
		this.equipes = this.eDAO.listar();
		return "/entidades/equipeLista";
	}

	public void excluir(Equipe equipe) {
		if (this.eDAO.excluir(equipe))
			JSFMensageiro.info("Equipe excluida com sucesso");
		else
			JSFMensageiro.error("Equipe não excluida");
		this.equipes = this.eDAO.listar();
	}
	public EquipeDAO geteDAO() {
		return eDAO;
	}

	public void seteDAO(EquipeDAO eDAO) {
		this.eDAO = eDAO;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public List<Equipe> getEquipes() {
		return this.eDAO.listar();
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	
	
}
