package com.curso.fullstack.sopra.mvc.dto;

public class Persona {

	private long id;
	
	private String nombre;

	public Persona() {
		super();
	}

	public Persona(long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
