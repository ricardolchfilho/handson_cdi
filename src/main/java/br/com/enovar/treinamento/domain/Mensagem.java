package br.com.enovar.treinamento.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.enovar.treinamento.infra.stereotype.ConversationalModel;

@ConversationalModel
public class Mensagem implements Serializable{
	
	private static final long serialVersionUID = 12664355409038120L;

	@NotEmpty(message = "E-mail do remetente Ž obrigat—rio")
	@Email(message = "E-mail do remente inv‡lido!")
	private String de;
	
	@NotEmpty(message = "E-mail do destinat‡rio Ž obrigat—rio")
	@Email(message = "E-mail do destint‡rio inv‡lido!")
	private String para;
	
	@NotEmpty(message = "T’tulo da mensagem Ž obrigat—rio")
	private String titulo;
	
	@NotEmpty(message ="Corpo da mensagem Ž obrigat—rio")
	private String assunto;

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

}
