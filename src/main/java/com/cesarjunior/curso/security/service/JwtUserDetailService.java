package com.cesarjunior.curso.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cesarjunior.curso.domain.Usuario;
import com.cesarjunior.curso.security.JwtUserFactory;
import com.cesarjunior.curso.service.UsuarioService;

@Service
public class JwtUserDetailService implements UserDetailsService{

	@Autowired
	private UsuarioService usuarioService;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.findByEmail(email);
		
		if(usuario == null) {
			throw new UsernameNotFoundException(String.format("Nenhum usuário encontrado com o email '%s' .", email));
		} else {
			return JwtUserFactory.create(usuario);
		}
	}

}
