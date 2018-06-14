package br.ucb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ucb.dao.EquipeDAO;
import br.ucb.modelo.Equipe;



@FacesConverter(value="equipeConverter")
public class EquipeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String strEquipeID) {
		return (new EquipeDAO()).consultar(Long.parseLong(strEquipeID));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object equipe) {
		return String.valueOf(((Equipe)equipe).getId());
	}

}
