package com.mcu.backend.apirest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mcu.backend.apirest.interfaces.IMenu;
import com.mcu.backend.apirest.interfaces.IOpcionesMenu;
import com.mcu.backend.apirest.models.RolMenu;

public interface IRolMenu extends JpaRepository<RolMenu, Integer> {
	@Query(nativeQuery = true,value = "SELECT "
			+ "usuario.nombre AS usuario,"
			+ "rol.rol_nombre,"
			+ "m1.nombre AS nombre_padre,"
			+ "m2.nombre AS nombre_hijo,"
			+ "m1.id AS id_padre,"
			+ "m2.id AS id_hijo "
			+ "FROM usuario "
			+ "LEFT JOIN usuario_rol  ON usuario.id= usuario_rol.usuario_id "
			+ "LEFT JOIN rol ON rol.id= usuario_rol.rol_id "
			+ "LEFT JOIN rol_menues ON rol_menues.id_rol = rol.id "
			+ "LEFT JOIN menues AS m1 ON m1.id = rol_menues.id_menu "
			+ "LEFT JOIN item_menues ON m1.id=item_menues.padre "
			+ "LEFT JOIN menues AS m2 ON m2.id = item_menues.hijo "
			+ " WHERE usuario.nombre= ?1 ")
	List<IMenu> obtenerMenu(String rolnombre);

	@Query(nativeQuery = true, value = "SELECT im.id as idimenu,im.hijo as idhijo,im.padre as idpadre,menu.accion as menu_accion "
			+ ",menu.nombre as menu_nombre,menu.tipo_menu as menu_tipo"
			+ " FROM item_menues AS im "
			+ "LEFT JOIN menues AS menu  ON menu.id = im.hijo "
			+ "WHERE im.padre=?1")
	List<IOpcionesMenu> obtenerOpcionesMenu(Integer idmenu);
}
