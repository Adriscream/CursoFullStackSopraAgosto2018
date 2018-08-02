package com.curso.fullstack.sopra.mvc.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.fullstack.sopra.mvc.dto.Mensaje;
import com.curso.fullstack.sopra.mvc.dto.Persona;
import com.curso.fullstack.sopra.mvc.bussiness.PersonasServicio;
import com.curso.fullstack.sopra.mvc.controllers.util.HttpHeadersUtil;

@RestController
//Identificamos el recurso con el que tabajamos en este servicio
@RequestMapping("/personas")
//@Controller
public class PersonaRestController {

	@Autowired
	private PersonasServicio personasServicio;
	
	@Autowired
	private HttpHeadersUtil httpHeadersUtil;
	
	//@ResponseBody
	@GetMapping("/{id}")
	public ResponseEntity<Persona> get(@PathVariable long id) {
		return new ResponseEntity<Persona>(
				personasServicio.getPersonaById(id), 
				HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Persona>> get() {
		return new ResponseEntity<List<Persona>>(
				personasServicio.getPersonas(), 
				HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> post(@RequestBody Persona persona) throws URISyntaxException {
		
		long id = personasServicio.nuevaPersona(persona);
		
		HttpHeaders headers = new HttpHeaders();
		
		httpHeadersUtil.addHeaderLocation(id, headers);
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Mensaje> delete(@PathVariable long id){
		personasServicio.borrarPersona(id);
		
		return new ResponseEntity<Mensaje>(
				new Mensaje("Se ha borrado el registro con id: " + id), 
				HttpStatus.OK);
	}
}
