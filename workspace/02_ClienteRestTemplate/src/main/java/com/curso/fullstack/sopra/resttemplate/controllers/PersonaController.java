package com.curso.fullstack.sopra.resttemplate.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.curso.fullstack.sopra.mvc.dto.Persona;

@Controller
@RequestMapping("/Persona")
public class PersonaController {

	private static final String URL_GET_PERSONA_ID = "http://{host}:{port}/{path}/{id}";
	private static final String PERSONA_REST_SERVICE_HOST = "localhost";
	private static final int PERSONA_REST_SERVICE_PORT = 8080;
	private static final String PERSONA_REST_SERVICE_PATH = "personas";
	
	//Hace las veces de servicio, ya que es la tipologia que nos da 
	//Spring para acceder a servicios web
	@Autowired
	private RestTemplate servicio;
	
	//http://localhost:8080/Persona/ConsultaPorId?id=1
	@GetMapping(path="/ConsultaPorId")
	public String consultarPersonaPorClave(
			@RequestParam long id, Model model) {
		
		HashMap<String, Object> params = new HashMap<>();
		
		params.put("host", PERSONA_REST_SERVICE_HOST);
		params.put("port", PERSONA_REST_SERVICE_PORT);
		params.put("path", PERSONA_REST_SERVICE_PATH);
		params.put("id", id);
		
		Persona persona = servicio.getForObject(
				URL_GET_PERSONA_ID, 
				Persona.class, 
				params);
		
		model.addAttribute("persona", persona);
		
		return "persona/detalle";
	}
	
	@GetMapping("/Consulta")
	public String consultarTodasLasPersonas() {
		return null;
	}
	
	@PostMapping("/Alta")
	public String crearNuevaPersona(
			@ModelAttribute("persona") Persona persona) {
		return null;
	}
	
	//http://localhost:8080/Persona/Baja?id=1
	@GetMapping("/Baja")
	public String borrarPersona(@RequestParam long id) {
		return null;
	}
}
