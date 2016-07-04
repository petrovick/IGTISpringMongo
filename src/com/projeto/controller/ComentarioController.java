package com.projeto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projeto.business.Comentario;
import com.projeto.business.Publicacao;
import com.projeto.repository.PublicacaoRepository;
import com.projeto.repository.UsuarioRepository;
import com.projeto.request.ComentarioRequest;
import com.spring.response.ComentarioResponse;

@Controller
@RequestMapping("/service/comentario")
public class ComentarioController
{
	@Autowired
	private PublicacaoRepository publicacaoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody String helloWorld() {
		
		return "teste";
	}
	
	@RequestMapping(value = "/adicionar", 
			consumes="application/json",
			produces = "application/json",
			method = RequestMethod.POST)
	@ResponseBody
	public ComentarioResponse adicionar(@RequestBody ComentarioRequest request)
	{
		ComentarioResponse response = new ComentarioResponse();
		try
		{
			Publicacao publicacao = publicacaoRepository.findOne(request.getPublicacao().getId());
			if(publicacao == null)
				throw new Exception("Esta publicação não existe.");
			Comentario comentario = request.getComentario();
			if(publicacao.getComentarios() == null)
			{
				comentario.setUsuario(usuarioRepository.findOne(request.getEmailComentarista()));
				List<Comentario> comentarios = new ArrayList<Comentario>();
				comentarios.add(comentario);
				publicacao.setComentarios(comentarios);
			}
			else
			{
				comentario.setUsuario(usuarioRepository.findOne(request.getEmailComentarista()));
				publicacao.getComentarios().add(request.getComentario());
			}
			publicacaoRepository.save(publicacao);
			response.setMessage("Salvo com sucesso.");
			response.setStatus(200);
		}
		catch(Exception ex)
		{
			response.setStatus(500);
			response.setMessage(ex.getMessage());
		}
		return response;
	}

}
