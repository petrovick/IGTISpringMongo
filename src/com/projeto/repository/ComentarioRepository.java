package com.projeto.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projeto.business.Comentario;


@Repository
//@Component
public interface ComentarioRepository extends MongoRepository<Comentario, String>{
}