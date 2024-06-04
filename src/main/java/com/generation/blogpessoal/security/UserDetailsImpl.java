package com.generation.blogpessoal.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.blogpessoal.model.Usuario;

//objetivo é informar para o Security os dados de acesso da API

public class UserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	
	//classe segurança que traz autorizações de acesso que o usuario tem
	private List<GrantedAuthority> authorities;
	

	public UserDetailsImpl(Usuario user) {
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}
	
	public UserDetailsImpl() {}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// autorizações de acesso do usuário
		return authorities;
	}

	@Override
	public String getPassword() {
		// retorna a senha do usuario
		return password;
	}

	@Override
	public String getUsername() {
		// retorna o usuario que esta tentando logar
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// Se a conta não expirou ele acessa - true
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// Se a conta não está bloqueada - true
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// Se a credencial não estiver expirada - true
		return true;
	}

	@Override
	public boolean isEnabled() {
		// Se o usuario esta habilitado - true
		return true;
	}
	
	
	
}
