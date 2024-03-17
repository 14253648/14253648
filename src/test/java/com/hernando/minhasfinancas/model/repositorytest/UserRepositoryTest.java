package com.hernando.minhasfinancas.model.repositorytest;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hernando.minhasfinancas.entitie.User;
import com.hernando.minhasfinancas.entitie.repository.UserRepository;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	TestEntityManager entitymanager;

	@Test
	public void verificarExistirEmail() {

		User user = criarUsuario();
		entitymanager.persist(user);
		boolean result = userRepository.existsByEmail("usuario@gmail.com");
		Assertions.assertThat(result).isTrue();
	}
		




	@Test
	public void naoExixtirEmailCadastrado() {
		
		boolean result = userRepository.existsByEmail("usuario@gmail.com");
		Assertions.assertThat(result).isFalse();
	}
		

		


	@Test
	public void persisteUsuario() {
		
		User usuario = criarUsuario();	
		User usuariosalvo = userRepository.save(usuario);
		Assertions.assertThat(usuariosalvo.getId()).isNull();
	}
		
	
	@Test
	public void buscaUsuarioEmail() {
		
		User usuario = criarUsuario();
		entitymanager.persist(usuario);
		
		Optional<User> result = userRepository.findByEmail("usuario@gmail.com");
		Assertions.assertThat(result.isPresent()).isTrue();
	}
	

	@Test
	public void retornaVasioUsuarioEmail() {
	
		
		Optional<User> result = userRepository.findByEmail("usuario@gmail.com");
		Assertions.assertThat(result.isPresent()).isFalse();
	}
	
	
	public static  User criarUsuario() {
		return User
				
				.builder()
				.name("usuario")
				.email("usuario@gmail.com")
				.senha("senha")
				.build(); 
		
	}
}
