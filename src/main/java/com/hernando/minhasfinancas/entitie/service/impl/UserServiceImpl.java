package com.hernando.minhasfinancas.entitie.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hernando.minhasfinancas.entitie.User;
import com.hernando.minhasfinancas.entitie.repository.UserRepository;
import com.hernando.minhasfinancas.entitie.service.exception.ErrorAutenticar;
import com.hernando.minhasfinancas.entitie.service.exception.RegraNegocioException;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User autenticar(String email, String senha) {
		Optional<User> usuario = userRepository.findByEmail(email);
		if(!usuario.isPresent()) {
			 throw new ErrorAutenticar("Usuário não encoontrado!");
		}
		if(!usuario.get().getSenha().equals(senha)) {
			throw new ErrorAutenticar("Senha inválida!");
		}
		return usuario.get();
	}

	@Override
	@Transactional
	public User salvarUsuario(User usuario) {
	validarEmail(usuario.getEmail());
		return userRepository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
	boolean existe = userRepository.existsByEmail(email);
	 if(existe) {
		 throw new RegraNegocioException("Ja existe usuário cadastrado com esse email!");
	 }
		
	}

}
