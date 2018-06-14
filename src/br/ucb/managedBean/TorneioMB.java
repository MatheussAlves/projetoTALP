package br.ucb.managedBean;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ucb.dao.TorneioDAO;
import br.ucb.modelo.Equipe;
import br.ucb.modelo.Torneio;
import br.ucb.util.JSFMensageiro;
@ManagedBean(name="torneioMB")
@SessionScoped
public class TorneioMB implements Serializable{
	private static final long serialVersionUID = 1L;
	private Torneio torneio;
	private List<Torneio> torneios;
	private TorneioDAO tDAO;
	
	
	public TorneioMB(){
		this.torneios = null;
		this.tDAO = new TorneioDAO();
		this.torneio = new Torneio();
	}
	
	public String listar(){
		this.torneios = this.tDAO.listar();
		return "/entidades/torneioLista";
	}
	public String incluir(){
		this.torneio = new Torneio();
		return "/entidades/torneioForm";
	}
	public String salvar() {
		if (this.torneio.getId() == 0) {
			if (this.tDAO.incluir(this.torneio))
				JSFMensageiro.info("Torneio incluido com sucesso");
			else
				JSFMensageiro.error("Erro ao incluir o torneio!");
		}
		else {
			if (this.tDAO.alterar(this.torneio))
				JSFMensageiro.info("Torneio alterado com sucesso!");
			else
				JSFMensageiro.error("Erro ao alterar o torneio!");
		}
		this.torneio = new Torneio();
		this.torneios.add(torneio);
		this.torneios = this.tDAO.listar();
		return "/entidades/torneioLista";
	}
	public void excluir(Torneio torneio) {
		System.out.println("teste");
		if (this.tDAO.excluir(torneio))
			JSFMensageiro.info("Equipe excluida com sucesso");
		else
			JSFMensageiro.error("Equipe não excluida");
		torneio.setEquipes(null);
		this.torneios = this.tDAO.listar();
	}

	public Torneio getTorneio() {
		return torneio;
	}

	public void setTorneio(Torneio torneio) {
		this.torneio = torneio;
	}

	public List<Torneio> getTorneios() {
		return torneios;
	}

	public void setTorneios(List<Torneio> torneios) {
		this.torneios = torneios;
	}

	public TorneioDAO gettDAO() {
		return tDAO;
	}

	public void settDAO(TorneioDAO tDAO) {
		this.tDAO = tDAO;
	}
	
}
