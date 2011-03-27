package br.com.enovar.treinamento.infra.log;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerProducer {

	@Produces
	@TreinamentoLogger
	public Logger produceLogger(InjectionPoint injectionPoint){
		return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
	
}
