package br.com.enovar.treinamento.infra.stereotype;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;

import br.com.enovar.treinamento.infra.log.Logged;

@Stereotype
@ConversationScoped
@Named
@Target({TYPE})
@Retention(RUNTIME)
@Documented
@Logged
public @interface ConversationalController {

}
