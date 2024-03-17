/*package com.hernando.minhasfinancas.entitie.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hernando.minhasfinancas.entitie.User;
import com.hernando.minhasfinancas.entitie.service.impl.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> buscarUsuarios() {
		List<User> list = service.buscarTodosUsuarios();
		return ResponseEntity.ok().body(list);
	}

	
	@PostMapping
	public ResponseEntity<User> postarUsuarios(@RequestBody User nome) {
	      nome = service.inserirUsuario(nome);
	      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(nome.getId()).toUri();
		return ResponseEntity.created(uri).body(nome);
	}
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<User>> buscarUsuarioId(@PathVariable Long id) {
		Optional<User> obj = service.buscarUsuarioId(id);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagarUsuario(@PathVariable Long id) {
		service.apagarUsuario(id);
		return ResponseEntity.noContent().build();
	}

}*/
