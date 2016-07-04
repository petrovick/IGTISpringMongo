package com.projeto.business;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "publicacao")
public class Publicacao {
	@Id
	private String id;
	private String descricao;
	@DBRef
	private Usuario usuario;
	private List<Comentario> comentarios;

    public Publicacao() { }

	public Publicacao(String id, Usuario usuario, List<Comentario> comentarios) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.comentarios = comentarios;
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

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
}