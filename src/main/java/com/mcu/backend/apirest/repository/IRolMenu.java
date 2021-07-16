package com.mcu.backend.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mcu.backend.apirest.models.rol_menu;

public interface IRolMenu extends JpaRepository<rol_menu, Integer> {
	@Query(nativeQuery = true,value = " SELECT rm.id,rm.nombre,rm.permiso,rm.id_rol FROM rol_menu rm , Rol r WHERE  rm.id=r=id AND r.rol_nombre = ?1 ")
	Optional<rol_menu> obtenerMenu(String rolnombre);
	
}
