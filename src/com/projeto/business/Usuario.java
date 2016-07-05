package com.projeto.business;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public class Usuario implements Serializable
{
	private static final long serialVersionUID = -3975234649523180989L;
	
	@Id
	private String id;
	private String email;
	private String nome;

	public Usuario() { }
	
	public Usuario(String id, String email, String nome) {
		super();
		this.id = id;
		this.email = email;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}