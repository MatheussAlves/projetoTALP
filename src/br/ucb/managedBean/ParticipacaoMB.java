package br.ucb.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ucb.dao.EquipeDAO;
import br.ucb.dao.ParticipacaoDAO;
import br.ucb.modelo.Equipe;
import br.ucb.modelo.Participacao;
import br.ucb.modelo.Torneio;
import br.ucb.util.JSFMensageiro;
@ManagedBean(name="participacaoMB")
@SessionScoped
public class ParticipacaoMB implements Serializable{
	static final long serialVersionUID = 1L;
	private Participacao participacao;
	private Torneio torneio;
	private List<Equipe> equipes;
	private List<Equipe> equipesSelecionadas;
	private EquipeDAO eDAO;
	private ParticipacaoDAO pDAO;
	public ParticipacaoMB(){
		this.torneio = new Torneio();
		this.participacao = new Participacao();
		this.eDAO = new EquipeDAO();
		this.pDAO = new ParticipacaoDAO();
		this.equipesSelecionadas = null;
	}

	@PostConstruct
	public void incluir(){
		this.equipes = this.eDAO.listar();
	}
	
	public String salvar(){
		this.participacao.setTorneio(torneio);
		for (Equipe equipe : getEquipesSelecionadas()) {
			this.participacao.setEquipe(equipe);
		}
		
		
		if(this.pDAO.incluir(participacao)){
			JSFMensageiro.info("Equipes incluidas com sucesso!");
		}else{
			JSFMensageiro.error("Equipes não incluidas!");
		}
		this.participacao = new Participacao();
		return "/entidades/torneioLista";
	}
	
	
	public Participacao getParticipacao() {
		return participacao;
	}


	public void setParticipacao(Participacao participacao) {
		this.participacao = participacao;
	}


	public Torneio getTorneio() {
		return torneio;
	}


	public void setTorneio(Torneio torneio) {
		this.torneio = torneio;
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

	public List<Equipe> getEquipesSelecionadas() {
		return equipesSelecionadas;
	}

	public void setEquipesSelecionadas(List<Equipe> equipesSelecionadas) {
		this.equipesSelecionadas = equipesSelecionadas;
	}

	public ParticipacaoDAO getpDAO() {
		return pDAO;
	}

	public void setpDAO(ParticipacaoDAO pDAO) {
		this.pDAO = pDAO;
	}
	
	
}


