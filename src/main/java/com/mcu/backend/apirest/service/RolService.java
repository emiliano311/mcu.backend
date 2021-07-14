package com.mcu.backend.apirest.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcu.backend.apirest.enums.RolNombre;
import com.mcu.backend.apirest.models.Rol;
import com.mcu.backend.apirest.repository.IRolRepository;

@Service
@Transactional
public class RolService {
	
	@Autowired
	private IRolRepository rolRepository;
	
	
	public Optional<Rol> getByRolNombre(RolNombre rolNombre){
		return rolRepository.findByRolNombre(rolNombre);
	}
	public void save(Rol rol) {
		rolRepository.save(rol);
	}
}
