package com.projeto.request;

import com.projeto.business.Comentario;
import com.projeto.business.Publicacao;

public class ComentarioRequest extends BaseRequest {
	private String emailComentarista;
	private Publicacao publicacao;
	private Comentario comentario;
	private String email;
	
	public ComentarioRequest() { }
	
	public ComentarioRequest(String emailComentarista, Publicacao publicacao, String email) {
		super();
		this.emailComentarista = emailComentarista;
		this.publicacao = publicacao;
		this.email = email;
	}

	public String getEmailComentarista() {
		return emailComentarista;
	}

	public void setEmailComentarista(String emailComentarista) {
		this.emailComentarista = emailComentarista;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}
}
