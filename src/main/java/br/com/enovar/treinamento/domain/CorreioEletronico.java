package br.com.enovar.treinamento.domain;

import com.guilhermechapiewski.fluentmail.transport.EmailTransportException;

public interface CorreioEletronico {

	void enviarEmail(Mensagem mensagem) throws EmailTransportException;
	
	public void encaminharLogDeEmailParaAdministrador(Mensagem mensagem) throws EmailTransportException;
	
}
