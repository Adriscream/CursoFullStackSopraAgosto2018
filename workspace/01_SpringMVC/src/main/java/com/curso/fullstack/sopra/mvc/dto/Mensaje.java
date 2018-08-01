package com.curso.fullstack.sopra.mvc.dto;

public class Mensaje {

	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Mensaje() {
		super();
	}

	public Mensaje(String texto) {
		super();
		this.texto = texto;
	}
}
