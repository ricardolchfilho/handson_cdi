package br.com.enovar.treinamento.infra.log;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;



@Interceptor
@Logged
public class LoggerInterceptor implements Serializable{
	
	private static final long serialVersionUID = 2152656397109338422L;
	
	private @Inject @TreinamentoLogger Logger logger;
	
	@AroundInvoke
	public Object aroundInvoke(InvocationContext context) throws Exception {
		logger.info("Executando método: "+ context.getMethod());
		return context.proceed();
		
	}
}
