package com.curso.fullstack.sopra.mvc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.fullstack.sopra.mvc.dto.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
