package com.felipe.mongodb.relacionamentos.relacionamentos.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document (collection = "postagens")
public class Postagem {
     @Id
     private String Id;
     private String titulo; 
     private String conteudo;
}
