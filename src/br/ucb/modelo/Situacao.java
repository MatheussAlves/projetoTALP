package br.ucb.modelo;

public enum Situacao {
	ABERTO("Aberto"),FECHADO("Fechado");
	
	private String nome;

	private Situacao(String nome){
		setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
