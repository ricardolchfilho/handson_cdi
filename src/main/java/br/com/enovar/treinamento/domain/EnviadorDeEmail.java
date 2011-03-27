package br.com.enovar.treinamento.domain;

import java.io.Serializable;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.guilhermechapiewski.fluentmail.email.EmailMessage;
import com.guilhermechapiewski.fluentmail.transport.EmailTransportConfiguration;
import com.guilhermechapiewski.fluentmail.transport.EmailTransportException;

public class EnviadorDeEmail implements CorreioEletronico, Serializable {

	private static final long serialVersionUID = 3241571433126397635L;
	
	private static final String EMAIL_ADMINISTRADOR = "lucastoc@gmail.com";
	private static final String EMAIL_AUDITORIA = "treinamento@enovar.com.br";
	
	private transient EmailTransportConfiguration configuracao;
	
	public EnviadorDeEmail(){}
	
	@Inject
	public EnviadorDeEmail(EmailTransportConfiguration configuracao){
		this.configuracao = configuracao;
	}
	

	@Override
	public void enviarEmail(Mensagem mensagem) throws EmailTransportException{
		new EmailMessage().from(mensagem.getDe()).to(mensagem.getPara()).withSubject(mensagem.getTitulo()).withBody(mensagem.getAssunto()).send();
	}
	
	@Override
	public void encaminharLogDeEmailParaAdministrador(@Observes @EventoDeAuditoria Mensagem mensagem) throws EmailTransportException{
		new EmailMessage().
			from(EMAIL_AUDITORIA).
			to(EMAIL_ADMINISTRADOR).
			withSubject("Auditoria").
			withBody("Este email: "+ mensagem.getDe() + " usou o sistema para envio de mensagens").
			send();
	}

}
