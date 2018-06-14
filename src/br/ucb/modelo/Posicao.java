package br.ucb.modelo;

public enum Posicao {
	SUPORTE("Suporte"),MEIO("Meio"),ATACANTE("Atacante");
	
	private String nome;
	
	private Posicao(String nome){
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
