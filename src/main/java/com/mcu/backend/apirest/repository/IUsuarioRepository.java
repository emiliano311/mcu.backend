package com.mcu.backend.apirest.repository;

import java.util.Optional;

import javax.swing.AbstractAction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcu.backend.apirest.models.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByNombre(String nombre);
	
	boolean existsByNombre(String nombre);
	
	//public Usuario findByNombre(String nombre);

}
