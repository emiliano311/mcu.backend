package com.mcu.backend.apirest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mcu.backend.apirest.models.RolMenu;

public interface IRolMenu extends JpaRepository<RolMenu, Integer> {
	@Query(nativeQuery = true,value = " SELECT DISTINCT"
			+ " rm.id,rm.nombre,rm.permiso,rm.id_rol,rm.url FROM "
			+ "usuario u, usuario_rol urol,rol_menu rm ,rol r "
			+ "WHERE u.id=urol.usuario_id AND urol.rol_id=r.id AND "
			+ "r.id=rm.id_rol AND u.nombre= ?1 ")
	List<RolMenu> obtenerMenu(String rolnombre);
	
}
