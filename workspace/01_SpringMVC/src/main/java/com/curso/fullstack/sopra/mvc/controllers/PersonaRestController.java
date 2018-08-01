package com.curso.fullstack.sopra.mvc.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

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

@RestController
//Identificamos el recurso con el que tabajamos en este servicio
@RequestMapping("/personas")
//@Controller
public class PersonaRestController {

	//@ResponseBody
	@GetMapping("/{id}")
	public ResponseEntity<Persona> get(@PathVariable long id) {
		return new ResponseEntity<Persona>(
				new Persona(id, "Victor"), 
				HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Persona>> get() {
		
		List<Persona> resultado = new LinkedList<>();
		
		resultado.add(new Persona(1, "Victor"));
		resultado.add(new Persona(2, "Juan"));
		
		return new ResponseEntity<List<Persona>>(
				resultado, 
				HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> post(@RequestBody Persona persona) throws URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		
		String id = "1";
		
		headers.setLocation(new URI("http://localhost:8080/personas/" + id ));
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Mensaje> delete(@PathVariable long id){
		return new ResponseEntity<Mensaje>(
				new Mensaje("Se ha borrado el registro con id: " + id), 
				HttpStatus.OK);
	}
	
}
