package br.ucb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ucb.dao.TorneioDAO;
import br.ucb.modelo.Torneio;
@FacesConverter(value="torneioConveter")
public class TorneioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String strIdTorneio) {
		// TODO Auto-generated method stub
		return (new TorneioDAO().consultar(Long.parseLong(strIdTorneio)));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object torneio) {
		// TODO Auto-generated method stub
		return String.valueOf(((Torneio)torneio).getId());
	}

}
