package com.projeto.business;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comentario")
public class Comentario
{
	@Id
	private String id;
	private String descricao;
	private Usuario usuario;
	
	public Comentario() { }
	public Comentario(String id, String descricao, Usuario usuario) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.usuario = usuario;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
