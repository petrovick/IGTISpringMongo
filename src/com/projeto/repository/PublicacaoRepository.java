package com.projeto.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projeto.business.Publicacao;


@Repository
//@Component
public interface PublicacaoRepository extends MongoRepository<Publicacao, String>{
}