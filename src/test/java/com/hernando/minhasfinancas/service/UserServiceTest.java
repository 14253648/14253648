package com.hernando.minhasfinancas.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.hernando.minhasfinancas.entitie.repository.UserRepository;
import com.hernando.minhasfinancas.entitie.service.exception.RegraNegocioException;
import com.hernando.minhasfinancas.entitie.service.impl.UserService;
import com.hernando.minhasfinancas.entitie.service.impl.UserServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setUp() {
		userRepository = Mockito.mock(UserRepository.class);
		userService = new UserServiceImpl(userRepository);

	}

	@Test(expected = Test.None.class)
	public void deveValidarEmail() {

		Mockito.when(userRepository.existsByEmail(Mockito.anyString())).thenReturn(false);

		userService.validarEmail("email@gmail.com");

	}

	@Test(expected = RegraNegocioException.class)
	public void erroExistirEmail() {

		Mockito.when(userRepository.existsByEmail(Mockito.anyString())).thenReturn(true);

	
		userService.validarEmail("email@gmail.com");
	}
}
