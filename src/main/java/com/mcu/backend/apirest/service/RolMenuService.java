package com.mcu.backend.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mcu.backend.apirest.enums.RolNombre;
import com.mcu.backend.apirest.models.Rol;
import com.mcu.backend.apirest.models.RolMenu;
import com.mcu.backend.apirest.repository.IRolMenu;

public class RolMenuService {

	@Autowired
	private IRolMenu rolMenu;
	
	/*public List<RolMenu> getByRolMenuNombre(String rolNombre){
		return rolMenu.obtenerMenu(rolNombre);
	}*/
	public void save(RolMenu rolm) {
		rolMenu.save(rolm);
	}
	
}
