package com.curso.fullstack.sopra.mvc.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.curso.fullstack.sopra.mvc.dto.Persona;

@Controller
public class PersonasController {

	//[GET] http://localhost:8080/persona/saludo/juan?prefix=Hola
	
	@GetMapping("/persona/saludo/{name}")
	public String saludo(@PathVariable(name="name", required=false) String nombre, 
			@RequestParam(name="prefix", required=false) String prefijo, Model model, HttpSession session) {
		
		session.setAttribute("nombre", nombre);
		
		model.addAttribute("dato", prefijo + " " + nombre + "!!!");
		
		return "exito";
	}
	
	@PostMapping("/persona/saludo")
	public ModelAndView saludo2(
			@SessionAttribute("nombre") String nombre, 
			@RequestBody Persona persona) {
		Map<String, Object> model = new HashMap<>();
		
		model.put("dato", "Este es un mensaje para la vista");
		model.put("persona", persona);
		
		return new ModelAndView("exito", model);
	}

}
