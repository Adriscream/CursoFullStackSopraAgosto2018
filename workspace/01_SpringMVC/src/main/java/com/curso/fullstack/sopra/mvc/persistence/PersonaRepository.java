package com.curso.fullstack.sopra.mvc.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.curso.fullstack.sopra.mvc.dto.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>, 
									QuerydslPredicateExecutor<Persona>{

	List<Persona> findByNombre(String nombre);
	
	//[SQL] SELECT P.* FROM PERSONAS AS P WHERE ID = ?
	//[SQL] SELECT * FROM PERSONAS WHERE ID = ?
	@Query("select p from Persona p where p.nombre = :name") //JPQL
	List<Persona> buscarPorNombre(@Param("name") String nombre);
	
	@Modifying
	@Query("update Persona p set p.nombre = ?1 where p.id = ?2")
	int cambiarNombreDePersonaPorId(String nombre, long id);
	
}
