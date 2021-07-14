package com.mcu.backend.apirest.creadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mcu.backend.apirest.enums.RolNombre;
import com.mcu.backend.apirest.models.Rol;
import com.mcu.backend.apirest.service.RolService;
@Component
public class CreateRoles {
	 /*implements CommandLineRunner
	@Autowired
	RolService rolService;
	
	@Override
	public void run(String... args) throws Exception {
		Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
		Rol rolUsuario = new Rol(RolNombre.ROLE_USER);
		rolService.save(rolAdmin);
		rolService.save(rolUsuario);
	}
*/
}
