package com.felipe.mongodb.relacionamentos.relacionamentos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.mongodb.relacionamentos.relacionamentos.models.Perfil;
import com.felipe.mongodb.relacionamentos.relacionamentos.models.Usuario;
import com.felipe.mongodb.relacionamentos.relacionamentos.repositories.PerfilRepository;
import com.felipe.mongodb.relacionamentos.relacionamentos.repositories.UsuarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

     @Autowired
     private UsuarioRepository usuarioRepository;

     @Autowired
     private PerfilRepository perfilRepository;

     @GetMapping
     public List<Usuario> getAll() {
          return usuarioRepository.findAll();
     }

     @GetMapping("/{id}")
     public Usuario findById(@PathVariable String id) {
          return usuarioRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
     }

     @PostMapping
     public Usuario create(@RequestBody Usuario usuario) {
          if (usuario.getPerfil() != null && usuario.getPerfil().getId() == null) {
               Perfil perfilSalvo = perfilRepository.save(usuario.getPerfil());
               usuario.setPerfil(perfilSalvo);
          }
          return usuarioRepository.save(usuario);
     }

     @PutMapping("/{id}")
     public String putById(@PathVariable String id, @RequestBody Usuario usuario) { 
          if (usuarioRepository.findById(id)) {
               
          }
          else {
               "Usuario não encontrado"
          }
         //TODO: process PUT request
         
         return ;
     }

}
