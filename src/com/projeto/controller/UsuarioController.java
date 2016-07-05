package com.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projeto.business.Usuario;
//import com.projeto.repository.UserRepository;
import com.projeto.repository.UsuarioRepository;
import com.projeto.request.UsuarioRequest;
import com.spring.response.UsuarioResponse;

@Controller
@RequestMapping("/service/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/adicionar", 
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
	@ResponseBody
	public UsuarioResponse adicionar(@RequestBody UsuarioRequest request)
	{
		UsuarioResponse response = new UsuarioResponse();
		try
		{
			
			Usuario usuarioExiste = usuarioRepository.findOne(request.getUsuario().getEmail());
			if(usuarioExiste == null)
			{
				usuarioExiste = usuarioRepository.insert(request.getUsuario());
				if(usuarioExiste == null)
					throw new Exception("Erro ao salvar usuário.");
			}
			else
			{
				usuarioExiste = usuarioRepository.save(request.getUsuario());
				if(usuarioExiste == null)
					throw new Exception("Erro ao salvar usuário.");
			}
			response.setMessage("Salvo com sucesso.");
			response.setStatus(200);
		}
		catch(Exception ex)
		{
			response.setMessage(ex.getMessage());
			response.setStatus(500);
		}
		return response;
	}
	{
		
	}
	
}