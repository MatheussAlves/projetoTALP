package br.ucb.managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ucb.modelo.Posicao;
import br.ucb.modelo.Situacao;

@ManagedBean(name="enumMB")
@ViewScoped
public class EnumMB implements Serializable{
	private static final long serialVersionUID = 1L;
	private Posicao posicoes;
	private Situacao situacoes;
	
	
	public Posicao[] getPosicoes() {
		return posicoes.values();
	}
	public void setPosicoes(Posicao posicoes) {
		this.posicoes = posicoes;
	}
	public Situacao[] getSituacoes() {
		return situacoes.values();
	}
	public void setSituacoes(Situacao situacoes) {
		this.situacoes = situacoes;
	}
	
	
	
}
