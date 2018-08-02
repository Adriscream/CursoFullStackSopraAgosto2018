package com.curso.fullstack.sopra.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.fullstack.sopra.mvc.dto.Persona;

@Configuration
public class H2Configuration {
	@Bean
	ServletRegistrationBean<Servlet> h2servletRegistration() {
		ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<Servlet>(
					new WebServlet(), "/console/*");
		return registrationBean;
	}
	
	/*@Bean
	List<Persona> misPersonas(){
		return new ArrayList<>();
	}*/
}
