package com.cesarjunior.curso.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cesarjunior.curso.enums.PerfilEnum;

@Document
public class Usuario {

	@Id
	private String id;
	
	@Indexed(unique=true)
	@NotBlank(message="E-mail é um campo obrigatório")
	@Email(message="E-mail inválido - não parece ser um e-mail")
	private String email;
	
	@NotBlank(message="Senha é um campo obrigatório!")
	private String senha;
	
	private PerfilEnum perfil;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}
}
