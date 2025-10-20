package com.felipe.mongodb.relacionamentos.relacionamentos.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipe.mongodb.relacionamentos.relacionamentos.models.Curso;

public interface CursoRepository extends MongoRepository<Curso, String> {   
       
}
