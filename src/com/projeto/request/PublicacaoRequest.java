package com.projeto.request;

import com.projeto.business.Comentario;
import com.projeto.business.Publicacao;

public class PublicacaoRequest extends BaseRequest {
	private String email;
	private Publicacao publicacao;
	
	public PublicacaoRequest() { }

	public PublicacaoRequest(String email, Publicacao publicacao) {
		super();
		this.email = email;
		this.publicacao = publicacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}
	
}
