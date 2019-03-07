package com.cesarjunior.curso.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private final String id;
	private final String username;
	private final String password;
	private final Collection<? extends GrantedAuthority> authorities;
	

	public JwtUser(String id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
	
	@JsonIgnore
	public String getId() {
		return id;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}


	@Override
	@JsonIgnore
	public String getPassword() {
		return password;
	}


	@Override
	public String getUsername() {
		return username;
	}


	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}
}
