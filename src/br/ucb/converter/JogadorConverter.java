package br.ucb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import br.ucb.dao.JogadorDAO;
import br.ucb.modelo.Jogador;
@FacesConverter(value="jogadorConverter")
public class JogadorConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String jogadorID) {
		return (new JogadorDAO()).consultar(Long.parseLong(jogadorID));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object jogador) {
		return String.valueOf(((Jogador)jogador).getId());
	}

}
