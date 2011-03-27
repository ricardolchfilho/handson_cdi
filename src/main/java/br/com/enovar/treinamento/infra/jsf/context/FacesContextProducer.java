package br.com.enovar.treinamento.infra.jsf.context;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Named;

public class FacesContextProducer {
	
	@Produces
	@Named("contexto")
	@RequestScoped
	public FacesContext produceFacesContext(){
		return FacesContext.getCurrentInstance();
	}

}
