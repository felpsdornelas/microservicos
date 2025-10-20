package com.felipe.mongodb.relacionamentos.relacionamentos.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipe.mongodb.relacionamentos.relacionamentos.models.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String> {   
       
}
