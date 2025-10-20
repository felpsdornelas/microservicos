package com.felipe.mongodb.relacionamentos.relacionamentos.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipe.mongodb.relacionamentos.relacionamentos.models.Estudante;

public interface EstudanteRepository extends MongoRepository<Estudante, String> {   
       
}
