
/*package com.hernando.minhasfinancas.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;

import com.hernando.minhasfinancas.entitie.Lancamento;
import com.hernando.minhasfinancas.entitie.User;
import com.hernando.minhasfinancas.entitie.repository.LancamentoRepository;
import com.hernando.minhasfinancas.entitie.repository.UserRepository;

@org.springframework.context.annotation.Configuration

@Profile("test")
public class Configuration implements CommandLineRunner {

	@Autowired
	private UserRepository useRepositore;

	@Autowired
	private LancamentoRepository lancamentorepository;

	@Override
	public void run(String... args) throws Exception {

		Lancamento lanc = new Lancamento(null, "Graduação", 2020, 03, 200.0);
		Lancamento lanc1 = new Lancamento(null, "Ensino Médio", 2010, 02, 300.0);
		Lancamento lanc2 = new Lancamento(null, "Ensino Fundamental", 2000, 03, 100.0);
		Lancamento lanc3 = new Lancamento(null, "Pós Graduação", 2025, 04, 500.0);

		lancamentorepository.saveAll(Arrays.asList(lanc, lanc1, lanc2, lanc3));

		User usuario = new User(null,"Dada", "dada@gamil.com", "12345");
		User usuario1 = new User(null,"Dede", "dede@gamil.com", "12345");
		User usuario2 = new User(null,"Didi", "didi@gamil.com", "12345");
		User usuario3 = new User(null,"Dodo", "dodo@gamil.com", "12345");
		User usuario4 = new User(null,"Dudu", "dudu@gamil.com", "12345");

		useRepositore.saveAll(Arrays.asList(usuario, usuario1, usuario2, usuario3, usuario4));
	}

}
*/