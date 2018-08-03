package com.curso.fullstack.sopra.mvc.bussiness;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.fullstack.sopra.mvc.dto.Persona;
import com.curso.fullstack.sopra.mvc.dto.QPersona;
import com.curso.fullstack.sopra.mvc.persistence.PersonaRepository;
import com.querydsl.core.types.Predicate;

@Service
public class PersonaServicioImpl implements PersonasServicio {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public Persona getPersonaById(long id) {
		
		//select p from Persona p where p.id = :id
		return personaRepository.findOne(QPersona.persona.id.eq(id)).get();
		
		//return personaRepository.findById(id).get();
	}

	@Override
	public List<Persona> getPersonas() {
		return personaRepository.findAll();
	}

	@Override
	public long nuevaPersona(Persona persona) {
		persona = personaRepository.saveAndFlush(persona);
		
		//Ahora enviamos el correo electronico
		//correoNegocio.enviarCorreo();
		
		return persona.getId();
	}

	@Override
	public void borrarPersona(long id) {
		personaRepository.deleteById(id);
	}

}
