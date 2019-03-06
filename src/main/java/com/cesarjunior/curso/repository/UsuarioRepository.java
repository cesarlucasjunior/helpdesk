package com.cesarjunior.curso.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cesarjunior.curso.domain.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
