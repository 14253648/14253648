package com.hernando.minhasfinancas.entitie.service.exception;

public class ErrorAutenticar extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public  ErrorAutenticar(String msg) {
		super(msg);
	}
}
