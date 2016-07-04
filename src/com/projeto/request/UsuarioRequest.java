package com.projeto.request;

import javax.xml.bind.annotation.XmlRootElement;

import com.projeto.business.Comentario;
import com.projeto.business.Publicacao;
import com.projeto.business.Usuario;
import com.projeto.dto.UsuarioDTO;
@XmlRootElement
public class UsuarioRequest extends BaseRequest {
	private Usuario usuario;
	
	public UsuarioRequest() { }

	public UsuarioRequest(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
