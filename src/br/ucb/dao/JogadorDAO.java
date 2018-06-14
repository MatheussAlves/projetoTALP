package br.ucb.dao;

import java.util.List;

import javax.persistence.Query;

import br.ucb.modelo.Jogador;

public class JogadorDAO extends GenericDAO<Jogador>{
	private static final long serialVersionUID = 1L;

	public List<Jogador> listaJogador(Long id){
		String jpql = "Select c from Jogador c "+"Where c.id = :id";
		Query query = this.getEm().createQuery(jpql);
		query.setParameter("id", id);
		return query.getResultList();
		
	}
}
