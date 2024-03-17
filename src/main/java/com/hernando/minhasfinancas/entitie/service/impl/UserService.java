package com.hernando.minhasfinancas.entitie.service.impl;

import org.springframework.stereotype.Service;

import com.hernando.minhasfinancas.entitie.User;

@Service
public interface UserService {

	
	User autenticar(String email, 	String senha);
	User salvarUsuario(User usuario );
	void validarEmail(String email);


}
