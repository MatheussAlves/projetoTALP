package br.ucb.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import br.ucb.dao.EquipeDAO;
//import br.ucb.dao.GenericDAO;
import br.ucb.dao.JogadorDAO;
import br.ucb.modelo.Equipe;
import br.ucb.modelo.Jogador;
import br.ucb.util.JSFMensageiro;
@ManagedBean(name="jogadorMB")
@SessionScoped
public class JogadorMB implements Serializable{
	private static final long serialVersionUID = 1L;
	private Jogador jogador;
	private JogadorDAO jDao;
	private List<Jogador> jogadoresPesquisados;
	private List<Jogador> jogadores;
	private List<Equipe> equipes;
	private EquipeDAO eDAO;
	public JogadorMB(){
		this.jogador = null;
		this.jDao = new JogadorDAO();
		this.eDAO = new EquipeDAO();
		this.jogadores = null;
		this.jogadoresPesquisados = null;
	}
	public String listar(){	
		this.jogadores = this.jDao.listar();
		return "/entidades/jogadorLista";
	}
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	public String salvar() {
		if (this.jogador.getId() == 0) {
			if (this.jDao.incluir(this.jogador))
				JSFMensageiro.info("Jogador incluido com sucesso");
			else
				JSFMensageiro.error("Erro ao incluir o jogador!");
		}
		else {
			if (this.jDao.alterar(this.jogador))
				JSFMensageiro.info("Jogador alterado com sucesso!");
			else
				JSFMensageiro.error("Erro ao alterar o jogador!");
		}
		this.jogador.getEquipe().getJogadores().add(this.jogador);
		this.jogador = new Jogador();
		this.jogadores = this.jDao.listar();
		return "/entidades/jogadorLista";
	}
	public String incluir() {
		this.jogador = new Jogador();
		this.equipes = this.eDAO.listar();
		return "/entidades/jogadorForm";
	}
	
	public void excluir(Jogador jogador) {
		jogador.getEquipe().getJogadores().remove(jogador);
		this.jDao.excluir(jogador);
		JSFMensageiro.info("Jogador excluido com sucesso");
		this.jogadores = this.jDao.listar();
		
		
	}
	public String pesquisar(){
		return "/entidades/pesquisaJogador";
	}
	public void lista(){
		System.out.println(jogador.getNome());
		this.jogadoresPesquisados = this.jDao.listaJogador(jogador.getId());
	}
	
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	public JogadorDAO getjDao() {
		return jDao;
	}
	public void setjDao(JogadorDAO jDao) {
		this.jDao = jDao;
	}
	public List<Equipe> getEquipes() {
		return equipes;
	}
	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
	public EquipeDAO geteDAO() {
		return eDAO;
	}
	public void seteDAO(EquipeDAO eDAO) {
		this.eDAO = eDAO;
	}
	public List<Jogador> getJogadoresPesquisados() {
		return jogadoresPesquisados;
	}
	public void setJogadoresPesquisados(List<Jogador> jogadoresPesquisados) {
		this.jogadoresPesquisados = jogadoresPesquisados;
	}
	
	
}
