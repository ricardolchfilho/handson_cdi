package br.com.enovar.treinamento.infra.mail;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import com.guilhermechapiewski.fluentmail.transport.EmailTransportConfiguration;

public class ConfiguradorDeEmailProducer {

	@Produces
	@Dependent
	public EmailTransportConfiguration gerarConfiguracaoDeSmtp(){
		
		EmailTransportConfiguration configuracao = new EmailTransportConfiguration();
		EmailTransportConfiguration.configure("smtp.gmail.com", true, true, "lucastoc@gmail.com", "xxxxx");
		
		return configuracao;
	}
	
}
