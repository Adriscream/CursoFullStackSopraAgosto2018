package com.curso.fullstack.sopra.mvc.bussiness;

import java.util.List;

import com.curso.fullstack.sopra.mvc.dto.Persona;

public interface PersonasServicio {

	Persona getPersonaById(long id);

	List<Persona> getPersonas();

	long nuevaPersona(Persona persona);

	void borrarPersona(long id);

}
