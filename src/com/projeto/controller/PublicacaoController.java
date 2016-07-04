package com.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projeto.business.Comentario;
import com.projeto.business.Publicacao;
import com.projeto.business.Usuario;
import com.projeto.repository.PublicacaoRepository;
import com.projeto.repository.UsuarioRepository;
import com.projeto.request.PublicacaoRequest;
import com.spring.response.PublicacaoResponse;

@RequestMapping("/service/publicacao")
@Controller
public class PublicacaoController {

	@Autowired
	private PublicacaoRepository publicacaoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/adicionar", 
			consumes="application/json",
			produces = "application/json",
			method = RequestMethod.POST)
	@ResponseBody
	public PublicacaoResponse adicionar(@RequestBody PublicacaoRequest request)
	{
		PublicacaoResponse response = new PublicacaoResponse();
		try
		{
			Usuario usuario = usuarioRepository.findOne(request.getEmail());
			Publicacao publicacao = request.getPublicacao();
			publicacao.setUsuario(usuario);
			if(publicacao.getId() == null)
			{//Criar nova publicacao
				publicacao = publicacaoRepository.insert(request.getPublicacao());
				if(publicacao == null)
				{
					throw new Exception("Erro ao salvar publicação, favor verifique os dados preenchidos.");
				}
			}
			else
			{//Atualizar publicacao
				publicacao = publicacaoRepository.save(publicacao);
				if(publicacao == null)
				{
					throw new Exception("Erro ao salvar publicação, favor verifique os dados preenchidos.");
				}
			}
		}
		catch(Exception ex)
		{
			response.setStatus(500);
			response.setMessage(ex.getMessage());
		}
		return response;
	}
	

}
