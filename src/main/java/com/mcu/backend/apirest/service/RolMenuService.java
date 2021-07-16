package com.mcu.backend.apirest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mcu.backend.apirest.enums.RolNombre;
import com.mcu.backend.apirest.models.Rol;
import com.mcu.backend.apirest.models.rol_menu;
import com.mcu.backend.apirest.repository.IRolMenu;

public class RolMenuService {

	@Autowired
	private IRolMenu rolMenu;
	
	public Optional<rol_menu> getByRolMenuNombre(String rolNombre){
		return rolMenu.obtenerMenu(rolNombre);
	}
	public void save(rol_menu rolm) {
		rolMenu.save(rolm);
	}
	
}
