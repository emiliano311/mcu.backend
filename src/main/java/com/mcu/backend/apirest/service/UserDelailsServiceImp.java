package com.mcu.backend.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mcu.backend.apirest.models.Usuario;
import com.mcu.backend.apirest.models.UsuarioPrincipal;

@Service
public class UserDelailsServiceImp implements UserDetailsService {

	@Autowired
	private UserService usuService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario= usuService.getByNombre(username).get();
		 
		return UsuarioPrincipal.build(usuario);
	}

	
}
