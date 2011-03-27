package br.com.enovar.treinamento.app;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.guilhermechapiewski.fluentmail.transport.EmailTransportException;

import br.com.enovar.treinamento.domain.CorreioEletronico;
import br.com.enovar.treinamento.domain.EventoDeAuditoria;
import br.com.enovar.treinamento.domain.Mensagem;
import br.com.enovar.treinamento.infra.stereotype.ConversationalController;

@ConversationalController
public class EmailController implements Serializable{
	
	private static final long serialVersionUID = 4786069507101057070L;
	
	private Conversation conversation;
	
	private FacesContext contexto;
	
	private CorreioEletronico enviador;
	
	private Event<Mensagem> evento;

	public EmailController(){}
	
	@Inject
	public EmailController(CorreioEletronico enviador,FacesContext contexto, Conversation conversation, @EventoDeAuditoria Event<Mensagem> evento){
		this.conversation = conversation;
		this.contexto = contexto;
		this.enviador = enviador;
		this.evento = evento;
	}
	
	public String prepararParaEnvioDeEmail(Mensagem mensagem){
		if(conversation.isTransient()){
			conversation.begin();
		}
		return "email.jsf?faces-redirect=true";
	}
	
	public String enviarEmail(Mensagem mensagem){
		
		try{
			enviador.enviarEmail(mensagem);
			evento.fire(mensagem);
			contexto.addMessage(null, new FacesMessage("E-mail enviado com sucesso!", null));
			conversation.end();
			return "sucesso";
			
		}catch(EmailTransportException e){
			e.printStackTrace();
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", null));
			return null;
		}
		
		
	}
	
}
