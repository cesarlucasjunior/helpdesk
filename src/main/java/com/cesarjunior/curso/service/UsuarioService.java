package com.cesarjunior.curso.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cesarjunior.curso.domain.Usuario;
import com.cesarjunior.curso.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	public Usuario create(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario update(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void delete(String id) {
		this.usuarioRepository.deleteById(id);
	}

	public Optional<Usuario> findById(String id) {
		return usuarioRepository.findById(id);
	}

	public Page<Usuario> findAll(int page, int qtdIndice) {
		PageRequest pageRequest = PageRequest.of(page, qtdIndice);
		return this.usuarioRepository.findAll(pageRequest);
	}
}
